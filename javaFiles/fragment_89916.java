public void join(String FilePath) {
    long leninfile=0, leng=0;
    int count=1, data=0;
    try {
        File filename = new File(FilePath);
        RandomAccessFile outfile = new RandomAccessFile(filename,"rw");
        while(true) {
            filename = new File(FilePath + count + ".sp");
            if (filename.exists()) {
                RandomAccessFile infile = new RandomAccessFile(filename,"r");
                data=infile.read();
                while(data != -1) {
                    outfile.write(data);
                    data=infile.read();
                }
                leng++;
                infile.close();
                count++;
            } else break;
        }
        outfile.close();
    } catch(Exception e) {
        e.printStackTrace();
    }
}