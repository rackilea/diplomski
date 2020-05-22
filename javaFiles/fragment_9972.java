class Person {
      private String SSN;
      //blah blah blah...

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String sSN) {
        SSN = sSN;
    }


    }

public class OldMan  extends Person {
    //codey stuff here...
      public void setSSN(String newSSN) {
        super.setSSN(newSSN);
      }
}