public class Runner
{
    public static void main(String[] args) throws Exception {
        var table = new HashTable<String, String>(12);

        table.Insert("Hello", "World");
        table.Insert("Hi", "man");
        table.Insert("world", "hello");
        table.Insert("cool", "word");




        System.out.println(table.Get("world"));

        System.out.println();

        table.PrintTable();


        table.Insert("cool", "word");
    }
}
