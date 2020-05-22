import java.util.*;

    public class A {
        public static void main(String []args){
    String str = "00011111122233322211111111110000000";
    str+='-';  //appended '-' to get last 0000000 as well into answer
                //otherwise it misses last string which i guess was your problem
    String one_element ="";
    int start=0;

    for(int i=1;i<str.length();i++){
       if(str.charAt(i)== str.charAt(i-1) )
          {

          }
       else{
          one_element = str.substring(start,i);
          start = i;
          System.out.println(one_element);//add one_element into ArrayList if required.
          }
      }
    }
  }