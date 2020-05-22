public class ClassA {

   private Long id;

   @Expose
   private String name;

   @Expose
   private boolean ok;

   @Expose
   private ClassB classB;

   @Expose
   private List<ClassC> classCList;

}

public class ClassB {

   private Long id;

   @Expose
   private String name;

   @Expose
   private ClassD classD;

}