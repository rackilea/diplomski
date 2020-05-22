import java.util.function.Supplier;

public class TestUserFunctions {

    public static Supplier<Boolean> equals(int val1, int val2){
        if(val1==val2){
            return () -> true;
        } else{
            return () -> false;
        }
    }
    public static Supplier<String> iterateValue(String ittr, int iterations){
      return () ->  {
         for(int i=1; i <= iterations; i++){
            System.out.println("Printing iteration #"+i);
         }
        return ittr;
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
        ifElse(equals(1, 1), iterateValue("Value", 1), iterateValue("Value", 3));
    }
}