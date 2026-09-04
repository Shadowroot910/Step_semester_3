public class level3 {

    static void findLongestStreak(String signalLog) {

        int count = 1;
        int max = 1;
        char color = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count > max) {
                max = count;
                color = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + color
                + "' repeated " + max + " times");
    }

    public static void main(String[] args) {

        String signalLog = "RRGGGYRR";

        findLongestStreak(signalLog);
    }
}