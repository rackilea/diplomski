package com.testpkg;
public class Person extends ScriptableObject {

   private int id; 
   private String string1;
   private String string2;
   private String string3;

   public Person() {
   }

   public void jsConstructor() {
       System.out.println("Person: jsConstructor");
       this.id = 0;
       this.string1 = "";
       this.string2 = "";
       this.string3 = "";
   }

   public int jsGet_id() {
       return this.id;
   }

   public void jsSet_id(int value) {
       this.id = value;
   }

   public String jsGet_string1() {
       return this.string1;
   }

   public void jsSet_string1(String value) {
       this.string1 = value;
   }

   public String jsGet_string2() {
       return this.string2;
   }

   public void jsSet_string2(String value) {
       this.string2 = value;
   }

   public String jsGet_string3() {
       return this.string3;
   }

   public void jsSet_string3(String value) {
       this.string3 = value;
   }

   @Override
   public String toString() {
       return id + " " + string1 + " " + string2 + " " + string3;
   }

   @Override
   public String getClassName() {
       return "Person";
   }

   public static Scriptable getInstance(String objectName) throws             IllegalAccessException, InstantiationException, InvocationTargetException  {
       Context jsContext = Context.enter();
       Scriptable person = null;
       try {
           ScriptableObject rootScope = jsContext.initStandardObjects();
           ScriptableObject.defineClass(rootScope, Person.class);
           person = jsContext.newObject(rootScope, "Person", null);
           rootScope.put(objectName, rootScope, person);
       }
       finally {
           Context.exit();
       }
       return person;
   }
}