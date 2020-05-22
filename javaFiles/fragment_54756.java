FileInputStream in = new FileInputStream(new File("C:\\Users\\Rachel\\Desktop\\Test.txt"));
DataInputStream din = new DataInputStream(new BufferedInputStream(in));
FileOutputStream fos = new FileOutputStream("C:\\Users\\Rachel\\Desktop\\MyOtherFile.txt");

byte b[] = new byte[512]; 
while(din.read(b) != -1){
    fos.write(b);
}

System.out.println("Got out");