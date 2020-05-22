class MyClass {
    static final String IMPORTANT_PROP_KEY = "xyz";
    MyProps props;

    MyClass(MyProps props) {
       this.props = props;
   }

   // this function didn't change
   void myFunc() {
       System.out.println("My prop is " + getMyProp()); // good
   }

   private String getMyProp() {
          return props.get(IMPORTANT_PROP_KEY); // good
   }

}