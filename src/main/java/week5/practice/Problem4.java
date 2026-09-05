public class Problem4 {

    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int value : row) {
            sum = sum + value;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            double average = rowAverage(seatingScores[i]);

            String zone;

            if (average < threshold) {
                zone = "Quiet Zone";
            } else {
                zone = "Buzzing Zone";
            }

            if (i > 0) {
                result = result + " | ";
            }

            result = result + "Row " + i + ": " + zone;
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] seatingScores = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };

        int threshold = 60;

        System.out.println(classifyRows(seatingScores, threshold));
    }
}