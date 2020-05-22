public class Main {

    private int a = 0;
    private int b = 1;

    public static void main(String[] args) { //Which will work here,

        Main main = new Main();
        main.Okay();

    }

    public Main() {

    }

    public void Okay() { //And here?
        if (a <= b) {
            System.out.println("Alright");
        } else {
            System.out.println("Okay Then");
        }
    }

}