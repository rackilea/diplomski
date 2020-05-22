public static void processGrades (String input_name, String csv_name, String pretty_name) {
    DecimalFormat decimalFormat = new DecimalFormat(".000000");

    String[][] data = readSpreadsheet(input_name);
    String[][] result = new String[data.length][];
    result[0] = new String[]{"name", "exam_score", "hw_score", "min_score", "grade"};

    // Export to 2D String array
    for(int row = 1; row < data.length; row++) {
        String name = data[row][0] + " " + data[row][1];
        double testAverage = average(data[row], 2, 5);
        double homeworkAverage = average(data[row], 5, 12);
        double min = Math.min(testAverage, homeworkAverage);
        char grade = (char) (74 - ((int) min / 10));
        grade = grade > 'D' ? 'F' : grade;

        result[row] = new String[]{
                name,
                decimalFormat.format(testAverage),
                decimalFormat.format(homeworkAverage),
                decimalFormat.format(min),
                Character.toString(grade)
        };
    }

    // Export 2D array into a csv String
    String csv = "";
    for (int y = 0; y < result.length; y++) {
        for (int x = 0; x < result[y].length - 1; x++) {
            csv += result[y][x] + ",";
        }
        csv += result[y][result[y].length - 1] + "\n";
    }

    // Save String in file
    File file = new File(csv_name);
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        bw.write(csv);
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static double average(String[] row, int fromIndex, int toIndex) {
    double total = 0;
    for (int i = fromIndex; i < toIndex; i++) {
        total += Integer.parseInt(row[i]);
    }
    return total / (toIndex - fromIndex);
}