class IntegerNumber {}

class PositiveNumber extends IntegerNumber implements Comparable<IntegerNumber> {}

class OddPositiveNumber extends PositiveNumber {}

private NewIterator<PositiveNumber> newIterator;
void foo() {
    Iterator<PositiveNumber> iterator = createIteratorFrom(
        new PositiveNumber(1),
        new OddPositiveNumber(7)
    );
    this.newIterator = new NewIterator(iterator);
}