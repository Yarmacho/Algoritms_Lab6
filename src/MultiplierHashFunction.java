import java.util.HashMap;
import java.util.Random;

public class MultiplierHashFunction<T> implements IHashFunction<T> {
    private Random _rand;
    private double _constant;
    private int _size;
    private HashMap<T, Integer> _cache;

    public MultiplierHashFunction()
    {
        _rand = new Random();
        _constant = _rand.nextDouble();
        _cache = new HashMap<>();
    }

    @Override
    public int Caluclate(T item)
    {
        var hash = _cache.get(item);
        if (hash == null)
        {
            hash = (int) (((item.hashCode() * _constant) % 1) * _size);
            _cache.put(item, hash);
        }
        return hash;
    }

    @Override
    public void SetSize(int size) {
        if (size < 0)
        {
            return;
        }
        _size = size;
    }
}
