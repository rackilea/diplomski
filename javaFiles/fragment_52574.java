public static void main(String[] args) {
    ArrayList<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();
    BufferedReader br = null;
    try {
        String sCurrentLine;
        br = new BufferedReader(new FileReader("testing.cvs"));

        while ((sCurrentLine = br.readLine()) != null) {
            String[] fields = sCurrentLine.split("\\$");
            for (int i = 0; i < fields.length; i++) {
                if (columns.size()<=i){
                    columns.add(new ArrayList<String>());
                }
                columns.get(i).add(fields[i]);
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null)br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}