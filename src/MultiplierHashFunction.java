import java.util.HashMap;
import java.util.Random;

public class MultiplierHashFunction<T> implements IHashFunction<T> {
    private Random _rand;
    private double _constant;
    private int _size;
    private HashMap<T, Integer> _cache;

    public MultiplierHashFunction(int hashTableSize)
    {
        _rand = new Random();
        _constant = _rand.nextDouble();
        _size = hashTableSize;
        _cache = new HashMap<>();
    }

    @Override
    public int Caluclate(T item)
    {
        var hash = _cache.get(item);
        if (hash == null)
        {
            hash = (int) ((calculate(item) * _constant) % 1 * _size);
            _cache.put(item, hash);
        }
        return hash;
    }

    private double  calculate(Object item)
    {
        if (item instanceof Number)
        {
            return calculate((Number) item);
        }
        else if (item instanceof String)
        {
            return calculate((String) item);
        }
        else
        {
            return item.hashCode();
        }
    }

    private double calculate(Number number)
    {
        return number.doubleValue();
    }

    private int calculate(String item)
    {
        var hash = 0;
        for ( int i = 0; i < item.length(); i++)
        {
            hash += (int)item.charAt(i);
        }

        return hash;
    }
}
