public class Test {
    public static void main(String[] args) {
        System.out.println("8:".matches("[,-:]+"));      // true: '8' is in the range ','..':'
        System.out.println("8:".matches("[,:-]+"));      // false: '8' does not match ',' or ':' or '-'
        System.out.println(",,-,:,:".matches("[,:-]+")); // true: all chars match ',' or ':' or '-'
    }
}