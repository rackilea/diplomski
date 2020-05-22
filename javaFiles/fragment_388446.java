import java.util.HashMap;
 import java.util.Scanner;
 import java.util.Set;

 public class Countcharacters {

/**
 * @param args
 */
static HashMap<String, Integer> countcharact=new HashMap<>();
static HashMap<String, String> linenumbertrack=new HashMap<>();
static int count=1;
static void countwords(String line){
    //System.out.println(line);
    String[] input=line.split("\\s");
    int j=0;
    String linenumber="";
    for(int i=0;i<input.length;i++){
        //System.out.println(input[i]);
        if(countcharact.containsKey(input[i])==true){
            j=countcharact.get(input[i]);
            linenumber=linenumbertrack.get(input[i]);
            countcharact.put(input[i],j+1);
            linenumbertrack.put(input[i],linenumber+" "+count);

        }
        else{
            countcharact.put(input[i], 1);
            linenumbertrack.put(input[i],count+" " );
        }

    }
    count++;


}
public static void main(String[] args) {
    // TODO Auto-generated method stub
   String inp="its am here in 1st line\ni am here in 2nd line";
   String[] line=inp.split("\n");
   for(int i=0;i<line.length;i++){
       Countcharacters.countwords(line[i]);
   }
    Set<String> s=countcharact.keySet();
    for(String c:s){
        System.out.println(countcharact.get(c)+" "+c+" "+linenumbertrack.get(c));
    }



}