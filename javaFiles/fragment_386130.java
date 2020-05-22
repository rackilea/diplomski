public abstract class SuperClass extends SomethingElse implements SomeOtherThing {
protected final PlmlForm plForm = null;

   String getData() { }

   // How can I do something like s.getReport()?
   // This is the way you call getReport
   String getReport()
   {
      return new SubClass().s.getReport();

      //If s is static...
      return SubClass.s.getReport();
   }

   //Illustrative example
   Subclass sub = new SubClass();
   sub.s.getReport(); // Here the magic happens
}

public class SubClass extends SuperClass {
   private Report report = null;

  /*
   * You create the object s that refers to Subclass
   */
   public SuperClass/SubClass s = this;
   //Or
   public static SuperClass/SubClass s = this;
   /********************************************/

    String getReport() { }
}

main(String[] args) {
    SuperClass s = this; // As SubClass extends from Superclass, for Java, it is the same as Superclass
    SubClass s = this; // And here it is the same, since SubClass and SuperClass in this case are the same
}