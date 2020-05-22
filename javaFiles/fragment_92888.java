class Outer{
   int i = 10;
   void main(){
      //instantiate inner class.
      Inner in = new Inner();
      in.show();
   }

   class Inner{
      void show(){
         System.out.print(i);
      }
   }
}