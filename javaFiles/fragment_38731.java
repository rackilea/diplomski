private void inputData(String fileName) {

    try {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        int studentIndex = 0;
        while ((line = bufferedReader.readLine())!=null)
        {
           String[] parts = line.split(";");
           myStudent[studentIndex] = new Student();
           myStudent[studentIndex].setID(parts[0]);
           myStudent[studentIndex].setName(parts[1]);
           myStudent[studentIndex].setQuiz1(Double.parseDouble(parts[2]));
           myStudent[studentIndex].setQuiz2(Double.parseDouble(parts[3]));
           myStudent[studentIndex].setQuiz3(Double.parseDouble(parts[4]));
           myStudent[studentIndex].setQuiz4(Double.parseDouble(parts[5]));
           myStudent[studentIndex].setQuiz5(Double.parseDouble(parts[6]));
           studentIndex++;

    }
        fileReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}