public static void main(String[] args) {

    BufferedReader br = null;
    BufferedWriter bw = null;

    String outFileName = "C:\\Users\\dokania\\Desktop\\New folder\\out.txt";
    File file1 = new File("C:\Users\dokania\Desktop\New folder\casp10.txt");

    try {

        String s;

        int fileCounter = 0;

        FileWriter fw = new FileWriter(outFileName);
        bw = new BufferedWriter(fw);

        br = new BufferedReader(new FileReader(file1));

        while ((s = br.readLine()) != null) {

            bw.write(s + "\n");

        }
        br.close();

        if (file1.delete()) {
            System.out.println(file1.getName() + " is deleted!");
        } else {
            System.out.println("Delete operation is failed.");
        }

    } catch (IOException e) {

        e.printStackTrace();
    } finally {

        try {

            if (br != null) {
                br.close();
                bw.close();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}