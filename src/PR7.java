import java.util.*;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;}

    public T getFirst() {
        return first;}
    public U getSecond() {
        return second;}

    public void setFirst(T first) {
        this.first = first;}
    public void setSecond(U second) {
        this.second = second;}

    public void swap() {
        T tempFirst = first;
        first = (T) second;
        second = (U) tempFirst;}

    @Override
    public String toString() {
        return "{" + first + ", " + second + "}";
    }
}

class Parametr {
    public static void main(String[] args) {

        Pair<String, Integer> pair1 = new Pair<>("Hello", 123);
        System.out.println("До swap: " + pair1);
        pair1.swap();
        System.out.println("После swap: " + pair1);

        Pair<Double, Double> pair2 = new Pair<>(3.14, 2.71);
        System.out.println("\nДо swap: " + pair2);
        pair2.swap();
        System.out.println("После swap: " + pair2);

        Pair<String, String> pair3 = new Pair<>("Java", "Python");
        System.out.println("\nДо swap: " + pair3);
        pair3.swap();
        System.out.println("После swap: " + pair3);
    }
}