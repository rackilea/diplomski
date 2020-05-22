public class ReadfileIntoArray {

    String[] columns = new String[] { "FName", "Lname", "Number" };
    String[] data = new String[100];

    public void read() throws IOException {
        FileReader fr = new FileReader("D:\\AllUserRecords.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        int i = 0;
        while ((line = br.readLine()) != null) {
            data[i] = line;
            System.out.println(data[i]);
            i++;
        }
        br.close();
        // This is for resize the data array (and data.length reflect new size)
        String[] dataNew = new String[i];
        System.arraycopy(data, 0, dataNew, 0, i);
        data = dataNew;
        System.out.println("Data length: " + data.length);
    }

    public static void main(String[] args) throws IOException {
        ReadfileIntoArray rfta = new ReadfileIntoArray();
        rfta.read();
    }
}