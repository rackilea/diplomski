public static void main(String[] args)throws Exception {
    DataOutputStream out = null; 
    DataInputStream in = null;
    try{
        out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("dec.dat")));
        in = new DataInputStream(new BufferedInputStream(new FileInputStream("enc.dat")));

        String enc=in.readUTF();
        System.out.println(enc);
    }catch(EOFException e){
    }
}