public class Example {

    int value;

    Example(int value) {
        this.value = value;
    }

    void bumpUp() {
        this.value++;
    }

    static Example makeExample(int startVal) {
        return new Example(startVal) {

            int bumpValue = 2;

            @Override
            void bumpUp() {
                this.bumpValue = (this.bumpValue == 2) ? 1 : 2;
                this.value += this.bumpValue;
            }
        };
    }

    public static void main(String[] args) {
        Example a = Example.makeExample(7);
        System.out.println(a.value);
        a.bumpUp();
        System.out.println(a.value);
        a.bumpUp();
        System.out.println(a.value);
        a.bumpUp();
        System.out.println(a.value);
        a.bumpUp();
        System.out.println(a.value);
        a.bumpUp();
        System.out.println(a.value);
    }
}