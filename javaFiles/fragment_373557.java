public static void main(String[] args) throws IOException {

    String fileName = new String();
    fileName = "items.txt";
    String outputFile = new String();
    outputFile = "so.txt";      
    String thisLine;
    HashSet<String> brand = new HashSet<>();
    FileInputStream fis = new FileInputStream(fileName);
    @SuppressWarnings("resource")
    BufferedReader myInput = new BufferedReader(new InputStreamReader(fis));
    while ((thisLine = myInput.readLine()) != null) {
        String[] line = thisLine.split("\t");
        if (line[20].equals("1")) {
            if (!line[2].equals("") && !line[2].equals(" ")
                    && !line[2].equals(null)) {                 
                if(line[2].indexOf("'") > -1){
                    System.out.println(line[2]);
                    line[2] = line[2].replace("'", "\'");
                    System.out.println(line[2]);
                }

                brand.add(line[2]);
            }
        }
        if (!line[3].equals("") && !line[3].equals(" ")
                && !line[3].equals(null)) {             
                line[3] = line[3].replace("'", "\'");               
            brand.add(line[3]);
        }
        if (!line[4].equals("") && !line[4].equals(" ")
                && !line[4].equals(null)) {
            if(line[4].indexOf("'") > -1){
                System.out.println(line[4]);
                line[4] = line[4].replace("'", "\'");
                System.out.println(line[4]);
            }


            brand.add(line[4]);
        }
    }

    String[] brands = brand.toArray(new String[brand.size()]);

    try {
        FileWriter fstream = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(fstream);
        for (int i = 0; i < brands.length; i++) {

            if (i == 0) {
                bw.write("'" + brands[i] + "'");
            } else {
                bw.write(",'" + brands[i] + "'");
            }
        }           

        bw.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}