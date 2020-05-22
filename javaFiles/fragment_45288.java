public class MyClass {
    private Random random = new Random(System.currentTimeMillis());

public double returnRandom() {
    return this.random.nextDouble();
}
}