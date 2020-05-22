public class Hello {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        if (args.length > 0) 
            sb.append(' ').append(args[0]);
        System.out.println(sb.append('.').toString());
    }
}