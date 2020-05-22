public static void main(String[] args) throws Exception {
    System.setOut(new PrintStream(new FileOutputStream("test.txt")));
    System.out.println("HelloWorld1");

     try {
       String line;
       Process p = Runtime.getRuntime().exec( "echo HelloWorld2" );

       BufferedReader in = new BufferedReader(
               new InputStreamReader(p.getInputStream()) );
       while ((line = in.readLine()) != null) {
         System.out.println(line);
       }
       in.close();
     }
     catch (Exception e) {
       // ...
     }
}