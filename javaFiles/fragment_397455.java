public static void main(String args[]) throws IOException {
String FilePath = "/Users/meh/Desktop/escapeplan.srt";
        FileInputStream fin = new FileInputStream(FilePath);

        System.out.println("size: " +fin.getChannel().size());
        long abc = 0l;
        abc = (fin.getChannel().size())/3;
        System.out.println("6: " +abc);
System.out.println("abc: " +abc);
       //FilePath = args[1];
        File filename = new File(FilePath);
        long splitFileSize = 0,bytefileSize=0;
        if (filename.exists()) {
            try {
                //bytefileSize = Long.parseLong(args[2]);
                splitFileSize = abc;
                Splitme spObj = new Splitme();
                spObj.split(FilePath, (long) splitFileSize);
                spObj = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File Not Found....");
        }
}
    public void split(String FilePath, long splitlen) {

            long leninfile = 0, leng = 0;
            int count = 1, data;
            try {
                File filename = new File(FilePath);
                InputStream infile = new BufferedInputStream(new FileInputStream(filename));
                data = infile.read();
                System.out.println("data");
                System.out.println(data);

                while (data != -1) {
                    filename = new File("/Users/meh/Documents/srt" + count + ".srt");
    //RandomAccessFile outfile = new RandomAccessFile(filename, "rw");

                    OutputStream outfile = new BufferedOutputStream(new FileOutputStream(filename));
                    while (data != -1 && leng < splitlen) {
                        outfile.write(data);
                        leng++;
                        data = infile.read();
                    }
                    leninfile += leng;
                    leng = 0;
                    outfile.close();
                    changeTimeStamp(filename, count);

                    count++;


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
}