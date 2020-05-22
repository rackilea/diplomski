RandomAccessFile in = new RandomAccessFile("/home/hduser/Documents/Sample.txt", "r");
String line;
long length = 0;//used to check the file length
while (true) {
    if(in.length()<length){//new condition to reset position if file length is reduced 
        in.seek(0);
    }
    if ((line = in.readLine()) != null) {
        System.out.println(line);
        length = in.length();
    } else {
        Thread.sleep(2000);
    }
}