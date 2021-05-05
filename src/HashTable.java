public class HashTable<T>
{
    private IHashFunction<T> _function;
    private T[] _table;

    public HashTable(int size) {
        _table = (T[]) new Object[size];
        _function = new MultiplierHashFunction<>(size);
    }

    public HashTable(int size, IHashFunction<T> function)
    {
        _table = (T[]) new Object[size];
        _function = function;
    }


    public void Insert(T item) throws Exception {
        var hash = _function.Caluclate(item);
        boolean firstCicle = true;
        while (hash < _table.length)
        {
            if (_table[hash] == null)
            {
                _table[hash] = item;
                return;
            }

            hash++;
            if (firstCicle && hash == _table.length - 1)
            {
                firstCicle = false;
                hash = 0;
            }
        }
        throw new Exception("Таблица заполнена полностью");
    }

    public void PrintTable()
    {
        for (int i = 0; i < _table.length; i++)
        {
            if (_table[i] != null)
            {
                System.out.println(String.format("hash: %d, value: %s", i, _table[i].toString()));
            }
        }
    }
}
