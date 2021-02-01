package be.intecbrussel.param;

public class WordReverser {
    public static void main(String[] args) {

    }

    public static String reverseWord(String word) {
        if(word == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String reversed = sb.append(word).reverse().toString();
        return reversed;
    }
}
