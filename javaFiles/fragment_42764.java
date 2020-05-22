class IntegerPrinter implements Consumer<Integer> {

@Override
public void accept(Integer integer) {
    System.out.println(integer);
}