abstract class X:
{
   // having this makes sure the person only uses a method they have 'overridden'
   private Exception makeException(){
        return new Exception("Called Method from abstract class that wasn't overridden");
   }
   void onDoneFragment1(){throw makeException();}
   void onDoneFragment2(){throw makeException();}
   void onDoneFragment3(){throw makeException();}
...
}