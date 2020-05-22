public static void main(String[] args) {
    String src = args[0];
    String dest = args[1];

    String fileName = Paths.get(src).getFileName().toString();

    System.out.println("fileName:" + fileName);

    String data;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fw = null;
    PrintWriter pw = null;
    try {
        fr = new FileReader(src);
        br = new BufferedReader(fr);
        fw = new FileWriter(dest + "\\" + fileName);
        pw = new PrintWriter(fw);
        data = br.readLine();
        while (data != null) {
            pw.println(data);
            data = br.readLine();
        }
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}