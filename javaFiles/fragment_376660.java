public class Singletons {
    private Example1 example1;
    private Example2 example2;
    private Example3 example3;

    private static Singletons instance;

    static {
        Example1 example1 = new Example1();
        Example2 example2 = new Example2();
        Example3 example3 = new Example3();

        instance = new Singletons();

        example1 = new Example1();
        example2 = new Example2();
        example3 = new Example3();

        example1.setExample2(example2);
        example2.setExample3(example3);
        example3.setExample1(example1);

        instance.setExample1(example1);
        instance.setExample2(example2);
        instance.setExample3(example3);
    }

    public Example1 getExample1() {
        return example1;
    }

    private void setExample1(Example1 example1) {
        this.example1 = example1;
    }

    public Example2 getExample2() {
        return example2;
    }

    private void setExample2(Example2 example2) {
        this.example2 = example2;
    }

    public Example3 getExample3() {
        return example3;
    }

    private void setExample3(Example3 example3) {
        this.example3 = example3;
    }

    public Singletons getInstance() {
        return instance;
    }
}