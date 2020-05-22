public class Myth extends Thread{
 public void run(){
   int val=65;
   try{
       for(int i=0;i<26;i++){
         System.out.println((char)val);
         val++;
         sleep(500);
        }
    }catch(InterruptedException e){
       System.out.println(e);
    }
 }

 public static void main(String args[]){
    Myth obj=new Myth();
    obj.start();
 }
}