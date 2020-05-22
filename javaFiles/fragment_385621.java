public class TestArraySort {

    public static void main(String[] args) {
        new TestArraySort();
    }

    public TestArraySort() {

        try {
            File file1 = new File("studentNames.txt");
            File file2 = new File("studentScores.txt");

            // Better to check for both files here, other wise it's just wasting time
            if (file1.exists() && file2.exists()) {
                // Create the sorted maps so that they are in scope...
                Map<Integer, String> mapStudents = new TreeMap<Integer, String>();
                Map<Integer, List<Double>> mapScores = new TreeMap<Integer, List<Double>>();

                Scanner input = null;
                try {
                    input = new Scanner(file1);
                    // Read the student information...
                    while (input.hasNext()) {
                        int id = input.nextInt();
                        String name = input.nextLine().trim();
                        mapStudents.put(id, name);
                    }
                    // Safty net
                } finally {
                    input.close();
                }

                try {
                    // Read the scores
                    input = new Scanner(file2);
                    while (input.hasNext()) {
                        int id = input.nextInt();
                        double score = input.nextDouble();

                        // If the list doesn't already exist, create it
                        List<Double> scores = mapScores.get(id);
                        if (scores == null) {
                            scores = new ArrayList<Double>(25);
                            mapScores.put(id, scores);
                        }
                        scores.add(score);
                    } /// end while
                    // Safty net
                } finally {
                    input.close();
                }

                // Dump the results
                System.out.println("+------------+----------------------+------+");
                for (Integer id : mapStudents.keySet()) {
                    // Display the student results
                    String name = mapStudents.get(id);
                    System.out.printf("| %10d | %-20s | ", id, name);
                    List<Double> scores = mapScores.get(id);
                    if (scores.size() > 0) {

                        // Sort the list
                        Collections.sort(scores);
                        // Reverse the list so that the scores are now in order from highest to lowest
                        // Sure, I could create a reverse comparator when I sort it, but
                        // I'm lazy...
                        Collections.reverse(scores);

                        // Print the first score...
                        System.out.printf("%4.1f |\n", scores.get(0));
                        // Print the remaining scores...
                        for (int index = 1; index < scores.size(); index++) {
                            System.out.printf("| %10s | %-20s | %4.1f |\n", "", "", scores.get(index));
                        }

                    } else {

                        System.out.println("00.0 |");

                    }
                    System.out.println("+------------+----------------------+------+");

                }

            } // end if(file2.exists)    }

        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}