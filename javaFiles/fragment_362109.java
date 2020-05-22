public static void main(String[] args) {

    String csvFile = "http://data.okfn.org/data/core/s-and-p-500-companies/r/constituents.csv";

    try {
        URL url12 = new URL(csvFile);
        URLConnection urlConn = url12.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);

        String line = buff.readLine();
        line  = buff.readLine();
        while (line != null) {

            System.out.println(line);
            line = buff.readLine();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}