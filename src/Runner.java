public class Runner
{
    public static void main(String[] args) throws Exception {
        var table = new HashTable<String>(12);

        table.Insert("HelloWorld");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");
        table.Insert("Hello");


        table.PrintTable();
    }
}
