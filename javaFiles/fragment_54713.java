class Dog {
   private List<MyBean> dataSet;

   // Enumerate the possible values of MyBean.name for a valid Dog object
   public final static String KIND = "kind";
   public final static String AGE = "age";
   public final static String BARFES = "heBarf";

   // Use a convenience Set for checks
   public static Set<String> validAttributes;

   // Put valid values in the convenience set once for all
   static {
     // trivial code to initialize the validAttributes set 
   }

   // We won't add setters, better constructing a new object every time
   public Dog(List<MyBean> v) {
      dataSet = v; // better copying ? as usual it depends on scenarios. 
   }

   // A convenience static to parse a string into this object.
   public static Dog parse(String theStream) {
      // cannot write since I don't know how is format, but this method can use the enumerations of the attribute names for checking. 
   }

   // Accessor
   public int getAge() {
      return dataSet.get(Dog.AGE);
   }

}