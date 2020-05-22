public static void myFunction(int lines, int files) throws FileNotFoundException, IOException {


    String inputfile = "C:/Users/Downloads/CONSOLIDATED.csv";
    BufferedReader br = new BufferedReader(new FileReader(inputfile));
    String strLine = br.readLine(); //here you have the headers
    String[] headers=strLine.split(",");

    for (int i = 1; i <= files; i++) {

        FileWriter fstream1 = new FileWriter("C:/Users/Downloads/FileNumber_" + i + ".csv");
        BufferedWriter out = new BufferedWriter(fstream1);

        out.write(headers[0]);

        for (int j = 0; j < lines; j++) {
            out.newLine();
            strLine = br.readLine();
            if (strLine != null) {

              String strar[] = strLine.split(",");
              out.write(strar[0]);
            }
        }
        out.close();
    }
    br.close();
}