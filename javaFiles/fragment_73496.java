public class SToken {

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("99 bottles of beer");
        int instrType = Integer.parseInt(tokenizer.nextToken());
        String hexAddr = tokenizer.nextToken();
        System.out.println(instrType + hexAddr);
    }
}