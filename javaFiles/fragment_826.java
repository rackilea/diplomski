class A implements ActionListener{
   @Override
   public void actionPerformed(ActionEvent ae) {
     //--- coding.........
   }

   //--- Somewhere in this class
   B b=new B(this);
}

class B{
   A a;
   public B(A a){
      this.a = a;
   }
   //-- now use this.a where you wanna set actionListener
}