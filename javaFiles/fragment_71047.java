public class RegularJavaClass {
   public static RegularJavaClass myObj;

   public RegularJavaClass(){}

   public static RegularJavaClass getInstance() {
    if (myObj == null) {
        myObj = new RegularJavaClass();
    }

    return myObj;
   }

    private int myNumValue;
    private String myStringValue;

    public int getMyNumValue() {
    return myNumValue;
    }
    public void setMyNumValue(int myNumValue) {
    this.myNumValue = myNumValue;
   }
    public String getMyStringValue() {
    return myStringValue;
    }
    public void setMyStringValue(String myStringValue) {
    this.myStringValue = myStringValue;
    }
   }