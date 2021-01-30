package be.intecbrussel;

public class Main {
    public static void main(String[] args) {
        Utilities util = new Utilities();
        String text = "Hello to unit testing with JUnit";
        char[] array = text.toCharArray();

        System.out.println(util.everyNthChar(array, 2));
        System.out.println(util.removePairs("AABCDDEFF"));
        System.out.println(util.converter(10, 2));
    }
}
