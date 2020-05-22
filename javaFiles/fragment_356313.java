public class Test {

    public static final String[] frames = {"|", "/", "-", "\\"};

    public static void main(String[] args) throws Exception {
        System.out.println();

        for (int ctr = 0; ctr < 50; ctr++) {
            System.out.print(frames[ctr % frames.length]);
            Thread.sleep(250);
            System.out.print("\b");
        }
    }
}