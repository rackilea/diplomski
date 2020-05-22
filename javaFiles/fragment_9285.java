public class CopyFile {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String fileName = ("C:\\Users\\yubaraj\\Desktop\\wonder1.txt");
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    try {
        StringBuilder stringBuilder = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line = br.readLine();
        }
        /**
         * Pass original file content as string to another method which
         * creates new file with same content.
         */
        newFile(stringBuilder.toString());
    } finally {
        br.close();
    }

  }

  public static void newFile(String fileContent) {
    try {
        String newFileLocation = "C:\\Users\\yubaraj\\Desktop\\new1.txt";
        PrintWriter writer = new PrintWriter(newFileLocation);
        writer.write(fileContent);//Writes original file content into new file
        writer.close();
        System.out.println("File Created");
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}