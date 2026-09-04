public class level5 {

    static void classifyWordLengths(String review) {

        String[] words = review.split(" ");

        int shortWord = 0;
        int medium = 0;
        int longWord = 0;

        for (int i = 0; i < words.length; i++) {

            int length = words[i].length();

            if (length <= 4) {
                shortWord++;
            } else if (length <= 8) {
                medium++;
            } else {
                longWord++;
            }
        }

        System.out.println("Short: " + shortWord
                + " | Medium: " + medium
                + " | Long: " + longWord);
    }

    public static void main(String[] args) {

        String review = "This movie was absolutely fantastic and thrilling";

        classifyWordLengths(review);
    }
}