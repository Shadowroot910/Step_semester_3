public class level4 {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < sectionA.length; i++) {
            sumA += sectionA[i];
            sumB += sectionB[i];
        }

        String status;

        if (sumA == sumB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }

        int max = sectionA[0];
        String section = "Section A";
        int index = 0;

        for (int i = 0; i < sectionA.length; i++) {

            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "Section A";
                index = i;
            }

            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "Section B";
                index = i;
            }
        }

        System.out.println("Section A Total: " + sumA);
        System.out.println("Section B Total: " + sumB);
        System.out.println("Status: " + status);
        System.out.println("Highest Quantity: " + max
                + " (" + section + ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}