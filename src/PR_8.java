import java.util.*;

abstract class PZ8User {
    String name;
    public PZ8User(String name) { this.name = name; }
    @Override
    public String toString() { return name; }
}

class PZ8Student extends PZ8User {
    int progress = 0;
    public PZ8Student(String name) { super(name); }
    public void addProgress() { progress += 20; }
    @Override
    public String toString() { return name + " (" + progress + "%)"; }
}

class PZ8Teacher extends PZ8User {
    public PZ8Teacher(String name) { super(name); }
    public void giveCertificate(PZ8Student s) {
        if (s.progress >= 80) System.out.println(s.name + " получил сертификат!");
        else System.out.println(s.name + " нужно больше уроков");
    }
}

class PZ8Lesson {
    String title;
    public PZ8Lesson(String title) { this.title = title; }
    @Override
    public String toString() { return title; }
}

class PZ8Course {
    String name;
    PZ8Teacher teacher;
    ArrayList<PZ8Lesson> lessons = new ArrayList<>();
    ArrayList<PZ8Student> students = new ArrayList<>();

    public PZ8Course(String name, PZ8Teacher teacher) {
        this.name = name;
        this.teacher = teacher;}

    public void addLesson(PZ8Lesson lesson) { lessons.add(lesson); }

    public void addStudent(PZ8Student s) {
        students.add(s);
        System.out.println(s.name + " записался на курс");}

    public void completeLesson(PZ8Student s, int lessonNum) {
        s.addProgress();
        System.out.println(s.name + " прошел урок: " + lessons.get(lessonNum));}
}

class PZ8Platform {
    String name;
    ArrayList<PZ8Course> courses = new ArrayList<>();
    public PZ8Platform(String name) { this.name = name; }
    public void addCourse(PZ8Course c) { courses.add(c); }
}

class PZ8 {
    public static void main(String[] args) {
        try {
            PZ8Platform platform = new PZ8Platform("LearnJava");
            PZ8Teacher teacher = new PZ8Teacher("Иван Петров");
            PZ8Course course = new PZ8Course("Java Basics", teacher);

            course.addLesson(new PZ8Lesson("Введение в Java"));
            course.addLesson(new PZ8Lesson("Переменные"));
            course.addLesson(new PZ8Lesson("Циклы"));
            course.addLesson(new PZ8Lesson("Массивы"));
            course.addLesson(new PZ8Lesson("Классы"));

            PZ8Student student1 = new PZ8Student("Анна");
            PZ8Student student2 = new PZ8Student("Петр");
            course.addStudent(student1);
            course.addStudent(student2);

            course.completeLesson(student1, 0);
            course.completeLesson(student1, 1);
            course.completeLesson(student1, 2);
            course.completeLesson(student1, 3);

            course.completeLesson(student2, 0);
            course.completeLesson(student2, 1);

            System.out.println("\nПрогресс:");
            System.out.println(student1);
            System.out.println(student2);

            System.out.println("\nСертификаты:");
            teacher.giveCertificate(student1);
            teacher.giveCertificate(student2);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}