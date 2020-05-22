class Outer{
      class Inner{
      }
      public static void main(String args[]){
            Outer.Inner obj = ((Outer) null).new Inner();
      } 
}