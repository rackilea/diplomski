public class LazyValidationExample {

    private List<Integer> fooList;

    public void putListExceptionCheckDoneLater(List<Integer> barList) {
        this.fooList = barList;
    }

    public List<Integer> getList() {
        if (this.fooList == null) throw new NullPointerException();
        return this.fooList;
    }
    ...
}