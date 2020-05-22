File infile = new File("Grades.txt");
Scanner myfile = new Scanner(infile);

while (myfile.hasNextLine()) {
    String line = myfile.nextLine();
    String[] parts = line.split("\\s+");
    double average = 0.0d;
    for (int i=1; i < parts.length; ++i) {
        average += Double.parseDouble(parts[i]);
    }
    average /= parts.length - 1;
    char letterGrade = determineGrade(average);

    System.out.println(parts[0] + " " + average + " " + letterGrade);
}