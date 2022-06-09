public class MainTest {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.insert("John", 20);
        ht.insert("Jane", 21);
        ht.insert("Jack", 22);
        ht.insert("Jill", 23);
        ht.insert("Jana", 24);
        ht.insert("Juan", 25);
        ht.increment("John");
        System.out.println(ht.toString());
        ht.delete("John");
        System.out.println(ht.toString());
        System.out.println(ht.getAge("John"));
        System.out.println(ht.getAge("Jane"));
        System.out.println(ht.search("Jill"));
    }
}
