interface Supplier<T> {
  public T get();
}

public class TestUserFunctions {

    public static Supplier<Boolean> equals(int val1, int val2){
        if(val1==val2){
          return new Supplier<Boolean>() {
            public Boolean get() { return true; }
          };
        } else{
          return new Supplier<Boolean>() {
            public Boolean get() { return false; }
          };
        }
    }
    public static Supplier<String> iterateValue(String ittr, int iterations){
      return new Supplier<String>() {
        public String get() {
          for(int i=1; i <= iterations; i++){
            System.out.println("Printing iteration #"+i);
          }
          return ittr;
        };
      };
    }

    private static void ifElse(Supplier<Boolean> condition, Supplier<String> returnstr, Supplier<String> elsestr){
        if(condition.get()){
            System.out.println("TRUE");
            returnstr.get();
        } else{
            System.out.println("FALSE");
            elsestr.get();
        }
    }

    public static void main(String[] args){
        ifElse(equals(1, 2), iterateValue("Value", 1), iterateValue("Value", 3));
    }
}