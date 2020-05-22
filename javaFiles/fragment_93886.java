public class Printer extends Thread {
    private String mText;

    public Printer(String text) {
        mText = text;
    }

    @Override
    public void run() {
        int num = 1_000;
        for (int i = 0; i < num; i++) {
            System.out.print(mText + " ");
        }
    }
}