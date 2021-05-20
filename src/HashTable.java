public class HashTable<TKey, TValue>
{
    private IHashFunction<TKey> _function;
    private KeyValuePair<TKey, TValue>[] _table;

    public HashTable(int size) {
        _table = new KeyValuePair[size];
        _function = new MultiplierHashFunction<>(size);
    }

    public HashTable(int size, IHashFunction<TKey> function)
    {
        _table = new KeyValuePair[size];
        _function = function;
    }


    public void Insert(TKey key, TValue item) throws Exception {
        var hash = _function.Caluclate(key);
        while (hash < _table.length)
        {
            if (_table[hash] != null && _table[hash].Key().equals(key))
            {
                throw new Exception("Значение с таким ключем уже содержиться в таблице!");
            }
            if (_table[hash] == null)
            {
                _table[hash] = new KeyValuePair<>(key, item);
                return;
            }

            hash++;
        }
        throw new Exception("Таблица заполнена полностью!");
    }

    public TValue Get(TKey key) throws Exception {
        var hash = _function.Caluclate(key);
        while (hash < _table.length)
        {
            if (_table[hash] == null)
            {
                throw new Exception("Таблица не содержит значения с такаим ключем");
            }
            if (_table[hash].Key().equals(key))
            {
                return _table[hash].Value();
            }

            hash++;
        }

        throw new Exception("Таблица не содержит такого значения!");
    }


    public void PrintTable()
    {
        for (int i = 0; i < _table.length; i++)
        {
            if (_table[i] != null)
            {
                System.out.println(String.format("hash: %d, value: %s", i, _table[i].Value().toString()));
            }
        }
    }


    private class KeyValuePair<TKey, TValue>
    {
        private TKey _key;
        private TValue _value;

        public KeyValuePair(TKey key, TValue value) {
            _key = key;
            _value = value;
        }

        public TKey Key() {
            return _key;
        }

        public TValue Value() {
            return _value;
        }
    }
}
