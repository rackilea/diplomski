public static void main(String[] args) {
    BufferedWriter writer = null;
    try{
        Path gabblePath = Paths.get("C:/Users/AlterionX/Documents/"
                 + "NetBeansProjects/File Creator, Function Example/src/file/"
                 + "gabble.txt");
        Charset cs = Charset.defaultCharset();
        Scanner scanner = new Scanner(System.in);
        String total = scanner.nextLine();
        System.out.println(total);
        writer = Files.newBufferedWriter(gabblePath, cs);
        writer.write(total);
        System.out.println("total printed");
    }catch(IOException ex){
        System.out.println("IO Exception");
    } finally {
        if (writer != null) {
            try {
                writer.close();
            }
            catch (IOException e) { /* ignore */ }
        }
    }
    System.exit(0);
}