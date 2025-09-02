public class Student {
    String name;
    int usn;
    static String college;

    Student(String n, int u) {
        name = n;
        usn = u;
        college = "JIT";
    }
    void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Usn: " + usn);
        System.out.println("College: " + college);
    }
    public static void main(String[] args) {
        Student s1 = new Student("Jack", 23);
        Student s2 = new Student("Jacie", 25);
        s1.printDetails();
        s2.printDetails();
    }
}
