try {
    BufferedReader r=new BufferedReader(new FileReader("file.txt"));
    int ch;
    while((ch=r.read())!=-1){
        System.out.print((char)ch);
    }
} catch(Exception e) {
    System.out.print((char)ch);
}