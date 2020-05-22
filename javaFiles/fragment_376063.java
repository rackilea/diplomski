class Main{
     public static void main(String[]args){
          new Thread(){
               @Override
               public void run(){
                       NameOfFirstJavaAppClass.main(fill,in,the,args);
               }
          }.start();
          new Thread(){
               @Override
               public void run(){
                       NameOfSecondJavaAppClass.main(fill,in,the,args);
               }
          }.start();
     }
}