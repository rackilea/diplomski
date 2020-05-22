public class Test {
    public static void main(String[] args) {
        try {
            Constructor<Util> utilC = Util.class.getDeclaredConstructor();
            utilC.setAccessible(true);
            Util u = utilC.newInstance(); // instance           
        } catch (Exception e) {
            // exception handling
        }
    }
}