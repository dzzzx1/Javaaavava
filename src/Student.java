public class Student {
    private String lastName;

    public Student(String lastName) {
        this.lastName = lastName;
    }

    public boolean compare(Student other) {
        return this.lastName.equals(other.lastName);
    }

    public boolean compare(String lastName) {
        return this.lastName.equals(lastName);
    }

    public static void main(String[] args) {
        Student student = new Student("Иванов");
        Student otherStudent = new Student("Петров");

        System.out.println(student.compare(otherStudent));
        System.out.println(student.compare("Иванов"));
    }
}