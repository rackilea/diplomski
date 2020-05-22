public class Program
{
    public static void main(String[] args) {
        Program program = new Program();
        String[] greeting = program.getGreeting();
        for (String word: greeting) {
            System.out.println(word);
        }
    }

    public String[] getGreeting() {
        return new String[] { "hello", "world" };
    }
}