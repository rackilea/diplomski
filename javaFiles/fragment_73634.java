public class arr {
    int index;

    public arr() {
        index = 1;
    }

    void go() {
        System.out.println(++index);
    }

    public static void main(String args[]) {
        (new arr()).go();
    }

}