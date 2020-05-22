public abstract class Person {
    protected int age;

    public void setAge(int age) {
        if(0 > age) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        this.age = age;
    }
}