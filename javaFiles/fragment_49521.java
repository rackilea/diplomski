class OuterClass
{
  int instanceVar;
  void InstanceMethod()
   {
      class InnerClass
       {
         int innerClassVar;
       }

       //...

       InnerClass myInstance = new InnerClass();
   }
}