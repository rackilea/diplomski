public class Animal { 
    protected int color;
    ...
}

public class Dog extends Animal implements IColorChangable {
    ...
    @Override public void changeColor () {
        color = ...;
    }
}