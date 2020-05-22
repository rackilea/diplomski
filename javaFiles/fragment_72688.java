public class Animal { 
    private int color;
    ...
    protected final void setColor (int color) { // could be public, could be non-final
        this.color = color;
    }
}

public class Dog extends Animal implements IColorChangable {
    ...
    @Override public void changeColor () { 
        setColor(...);
    }
}