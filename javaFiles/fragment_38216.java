public class ClassA {
   private Utility u = new Utility()

   public ClassA() {
       u.setSomething("David");
   }

   public Utility getU() {
        return u;
   }
}

 public class ClassB {
     private ClassA classA = new ClassA();

     public ClassB() {
         System.out.println(classA.getU().getSomething());
     }

 }

public class Utility {
   private String fullName;

   public void setSomething(String name) {
      this.fullName = name;
   }

   public String getSomething() {
      return fullName;
   }
}

public static void main(String[] args) {
    ClassB b = new ClassB();
}