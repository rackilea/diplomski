interface MyThing
{
   public void doMyThing(String subject);
   public List<String> getThingNames();
}

class D
{
   static void doSomethingComplicatedWithMyThing(MyThing thing)
   {
      for (String name : thing.getThingNames())
      {
         boolean useThing = /* complicated logic */
         if (useThing)
           thing.doMyThing(name);
      }
   }
}

class A extends SomeClass implements MyThing
{
   /* implement methods of MyThing */

   void doSomethingComplicated()
   {
      D.doSomethingComplicatedWithMyThing(this);
   }
}

class B extends SomeOtherClass implements MyThing
{
   /* implement methods of MyThing */

   void doSomethingComplicated()
   {
      D.doSomethingComplicatedWithMyThing(this);
   }
}

class C extends YetAnotherClass implements MyThing
{
   /* implement methods of MyThing */

   void doSomethingComplicated()
   {
      D.doSomethingComplicatedWithMyThing(this);
   }
}