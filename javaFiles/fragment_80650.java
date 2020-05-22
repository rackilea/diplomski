private void UpdateConfig() {
    File fstream = new File("c:\\user\\config.properties");
    File file = new File("c:\\user\\config.properties-new");
    try {
        file.createNewFile();
    } catch (IOException e) {
        // handle
    }
    try (FileReader in = new FileReader(fstream);
         FileWriter fw = new FileWriter(file.getAbsoluteFile())) {

        try (BufferedReader br = new BufferedReader(in);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("FTPDate=2014/07/01 00:59:00")) {
                    System.out.println("FILE " + strLine);
                    strLine = strLine.replace("FTPDate=2014/07/01 00:59:00",
                            "FTPDate=2014/09/10 00:00:00");
                    //strLine.replace("((19|20)\\d\\d/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])) ([2][0-3]|[0-1][0-9]|[1-9]):[0-5][0-9]:([0-5][0-9]|[6][0])", "2014/09/10 00:00:00");
                    bw.write(strLine);
                    System.out.println("FILE " + strLine);
                }
            }
        }
        // copy files here
    } catch (IOException e) {
        // handle
    }
}