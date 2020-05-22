public interface A<TB extends A.B<?>> {

    public interface B<TA extends A<? extends A.B<?>>> {

        void setA(TA a);
    }
}


class AImplTwo<TB extends A.B<TA>, TA extends AImplTwo<TB, TA> super AImplTwo<TB, TA>> implements A<TB> {

    private final TB b;

    public AImplTwo(TB b) {
        this.b = b;
        b.setA((TA)this);
    }
}