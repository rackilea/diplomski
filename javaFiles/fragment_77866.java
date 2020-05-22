public class Test {

    public static void main(String[] args) {
        foo();
    }

    private static void foo(){
        throw new Pig("Pigs can fly!");
    }

    public static class Pig extends RuntimeException {
        public Pig(String message){
            super(message);
        }
    }

}