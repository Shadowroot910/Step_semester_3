import java.util.*;

public class StopWordFilteredWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        String[] stop = {"the", "was", "and", "a", "is", "of", "in"};

        feedback = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> m = new HashMap<>();

        for (String w : words) {
            boolean skip = false;

            for (String s : stop) {
                if (w.equals(s)) {
                    skip = true;
                    break;
                }
            }

            if (!skip)
                m.put(w, m.getOrDefault(w, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(m.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> x : list)
            System.out.println(x.getKey() + ": " + x.getValue());
    }

    public static void main(String[] args) {
        printFilteredWordFrequency(
                "The mentor was great, the session was great and clear."
        );
    }
}