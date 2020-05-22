List<? super Something> list = someListReference;

public void methodThatPopulatesAList(List<? super Something> consumer) {
    ...
    list.add(new Something());
    ...
}