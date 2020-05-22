public class CompareFile {

  public static void main(String args[]) throws IOException{

   String line1;
   String line2;
   boolean found;
   int notequalcnt =0;

   BufferedReader bfpart = new BufferedReader(new FileReader("file1.txt"));

   while((line1 = bfpart.readLine())!=null){
    found = false;
    BufferedReader bfin = new BufferedReader(new FileReader("file2.txt"));
    while((line2 = bfin.readLine())!=null){

        System.out.println("line1"+line1);
        System.out.println("line2"+line1);
        if(line1.equals(line2)){
            System.out.println("equal");

            found = true;
            break;

        }
        else{
            System.out.println("not equal");

        }
    }
    bfin.close();

    if(found==false)
      notequalcnt++;
    }
    bfpart.close();
  }
}