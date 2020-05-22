public class Bar extends Foo {

    private Foo fa;

    public bar(Foo fa) {
        super();
        this.fa = fa;
    }

    @Override
    public void setNumber (int number) {
        fa.setNumber(number);
    }

    @Override
    public int getNumber () {
        return fa.getNumber();
    }
}