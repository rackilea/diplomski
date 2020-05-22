abstract class Foo<K extends FooKey> {
    private K key;

    public void setKey(K key){
        this.key = key;
    }
}

final class Bar extends Foo<BarKey> {
}