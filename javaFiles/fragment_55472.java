public class PrePostIncrement {
    int value;

    public PrePostIncrement(int value) {
        this.value = value;
    }

    public int preIncrement() {
        this.value = this.value + 1;
        return (this.value);
    }

    public int postIncrement() {
        int result = this.value;
        this.value = this.value + 1;
        return (result);
    }

    public static void main(String... args) {
        PrePostIncrement test = new PrePostIncrement(1111);
        int newValue = test.postIncrement();
        System.out.println(newValue);
    }
}