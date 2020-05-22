public class Animal implements IColorChangable {
    private int color;
    ...
    @Override public void changeColor () {
        color = ...;
    }
}

public class Dog extends Animal {
    ...
}