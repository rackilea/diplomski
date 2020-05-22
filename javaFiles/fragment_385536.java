@Data
public class B extends A {
    Integer b1;

    @Builder
    public B(Integer b1, Integer a1) {
        super(a1);
        this.b1 = b1;
    }

    public static class BBuilder extends ABuilder{
            BBuilder() {
                super();
            }
    }
}