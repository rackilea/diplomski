public static void main(String[] args) {
    try {
        BufferedReader br = new BufferedReader(new FileReader("grades.txt"));
        String line;
        int lowestNumber = Integer.MAX_VALUE;
        int number;
        while ((line = br.readLine()) != null) {
            try {
                number = Integer.parseInt(line);
                lowestNumber = number < lowestNumber ? number : lowestNumber;
            } catch (NumberFormatException ex) {
                // print the error saying that the line does not contain a number
            }
        }
        br.close();
        System.out.println("Lowest number is " + lowestNumber);
    } catch (IOException ie) {
        // print the exception
    }
}