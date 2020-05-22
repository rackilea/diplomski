public class WriteToFile {

    public static Data data;

    public void writeToFileExample() {

        BufferedWriter bw = null;
        try {
            File file = new File("google1.txt");
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(data.getDate() + " " + data.getTime());
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if(bw != null) 
                    bw.flush();
                    bw.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
         System.out.println("\n Written into file succesfully");       
    }

    public static void main(String args[]) throws IOException {

        data = new Data("Tuesday", 12);
        WriteToFile wtf = new WriteToFile();
        wtf.writeToFileExample();
    }
}