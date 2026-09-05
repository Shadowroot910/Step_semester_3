import java.util.Arrays;

public class Problem5 {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // CGPA-only eligibility
        static boolean isEligible(double cgpa) {

            return cgpa >= 7.5;
        }

        // CGPA + coding score eligibility
        static boolean isEligible(double cgpa, int codingScore) {

            return cgpa >= 6.5 && codingScore >= 60;
        }

        // Composite score
        double getCompositeScore() {

            return (cgpa * 10) + (codingScore * 0.5);
        }

        // Used by Arrays.sort()
        @Override
        public int compareTo(Candidate other) {

            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }

        public String getName() {
            return name;
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        // Find eligible candidates
        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        // Create array with exact number of shortlisted candidates
        Candidate[] finalShortlist = Arrays.copyOf(shortlisted, count);

        // Sort using compareTo()
        Arrays.sort(finalShortlist);

        String result = "";

        // Create final ranking
        for (int i = 0; i < finalShortlist.length; i++) {

            if (i > 0) {
                result = result + " | ";
            }

            result = result
                    + (i + 1)
                    + ". "
                    + finalShortlist[i].getName()
                    + " ("
                    + finalShortlist[i].getCompositeScore()
                    + ")";
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

                new Candidate("Aisha", 8.2, 40),

                new Candidate("Rohit", 6.8, 65),

                new Candidate("Meena", 6.0, 90),

                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}