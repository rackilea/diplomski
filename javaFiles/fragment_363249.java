public void runn() {
    String csvFile = "D:\\Html1.csv";
    BufferedReader br = null;
    String line = "";
    String abc = "";
    try {
        br = new BufferedReader(new FileReader(csvFile));
        while (br.ready()) {
            line = br.readLine();
            System.out.println(line);
            abc = line + "--";
        }
        setText(abc);
    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println("Done");
}