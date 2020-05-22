public void enclosingClassMethod(){
      InnerClass iC = new InnerClass();
      iC.innerClassPrivateMethod();   // this one works but why the following line doesn't       //work

      InnerClass.innerClassPrivateMethod();  // This also works...


}



public static class InnerClass{     //  Class converted to static 
     private static void innerClassPrivateMethod(){   // Method converted to static

     }

}