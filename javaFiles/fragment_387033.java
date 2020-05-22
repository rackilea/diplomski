public class HelloWorld{

static String s="140.184.37.105 - - [08/Aug/2001:21:06:36 -0300] \"GET /~csc226/outline.htm HTTP/1.0\" 200 9748 \"http://cs.stmarys.ca/~csc226/\" \"Mozilla/4.73 [en] (WinNT; U)";


     public static void main(String []args){
        System.out.println(getIp());
        System.out.println(getTime());

     }


     public static String getIp(){

         String sArr[]= s.split("-");
         return sArr[0];


     }

     public static String getTime(){


         return s.substring(21,46);

     }

  //more functions here   

}