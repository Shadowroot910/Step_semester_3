package assignment;

public class WordReversalEncoder {

    static String reverseEachWord(String sentence) {
        String[] w = sentence.split(" ");
        StringBuilder r = new StringBuilder();

        for (String x : w) {
            r.append(new StringBuilder(x).reverse()).append(" ");
        }

        return r.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}