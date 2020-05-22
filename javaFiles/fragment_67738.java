public static void printUSER()
{
BufferedReader br = null;
BufferedReader br1 = null;
try {
    br = new BufferedReader(new FileReader("info.txt"));
    br1 = new BufferedReader(new FileReader("info AI.txt"));
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
 String line = null;
 String line1 = null;

 try {
    while((line = br.readLine())!= null) {
      line1 = br1.readLine()
        if(line1 != null){
       System.out.println(line+"  ===  "+line1);
        }
     }
 } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
 }
}