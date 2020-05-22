// Your interface.
public interface MyButtonListener {
    public void buttonClicked ();
}

// Somewhere else:
Button fc = ...;
fc.addButtonListener(new MyButtonListener () {
    @Override public void buttonClicked () {
        // do stuff here
    }
});

// And in your Button have it simply iterate through all of its registered
// MyButtonListeners and call their buttonClicked() methods.