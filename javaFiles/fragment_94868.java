class MyClass {

   static final String IMPORTANT_PROP_KEY = "xyz";
   String myProp;

   MyClass(MyProps props) {
       this.myProp = props.get(IMPORTANT_PROP_KEY);
   }

   void myFunc() {
       System.out.println("My prop is " + getMyProp()); // good
   }

   private String getMyProp() {
       return myProp; // good
   }

}