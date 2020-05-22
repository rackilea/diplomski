public class Example {

    public static void main(String[] args) {

        int[] array = new int[] {12, 14, 523, 5423, 12, 0 ,14, -3, 521, 2};
        int pos = 0;
        for (int i = 0; i < 16; i++) {
            array[i] = -1;
            pos = increment(pos);
        }
    }

    static int increment(int pos) {

        int num = pos + 1;
        return num;
    }
}