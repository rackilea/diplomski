public static void main(String[] args) throws IOException {

    File outFile = new File( "fileOutput.txt" );
    FileOutputStream fos = new FileOutputStream(outFile);

    String numbers = "";

    Random rand = new Random();

    for(int i=1;i<=10001;i++){
        numbers += rand.nextInt(10001);
    }

    byte[] bytesArray = numbers.getBytes();
    fos.write(bytesArray);
    fos.flush();
    fos.close();
}