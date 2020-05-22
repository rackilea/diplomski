public static void main(String[] args) throws Exception {
    Runtime r = Runtime.getRuntime();
    Process p = r.exec("ghci");
            p.waitFor();
    OutputStream output = p.getOutputStream();
    ByteArrayOutputStream byte1=new ByteArrayOutputStream();
    output.write(byte1.toByteArray());
    String result=byte1.toString();
    System.out.println(result);
    p.destroy();  
}