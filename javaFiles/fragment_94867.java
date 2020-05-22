class MyClass {
    static final String IMPORTANT_PROP_KEY = "xyz";
    MyProps props;

    MyClass(MyProps props) {
       this.props = props;
   }

   void myFunc() {
       System.out.println("My prop is " + props.get(IMPORTANT_PROP_KEY)); // ugly
   }

}