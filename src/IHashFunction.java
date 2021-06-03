public interface IHashFunction<T>
{
    int Caluclate(T item);
    void SetSize(int size);
}
