public interface Performable {
    public void someMethod();
}

public class GUI implements Performable {
    private JTextField field = ..

    public GUI() {
        SomeListener listener = new SomeListener(GUI.this);
    }

    @Override
    public void someMethod() {
         field.setText("Hello");
    }
}

public class SomeListener implements ActionListener {
    private Performable perf;

    public SomeListener(Performable perf) {
        this.perf = perf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        perf.someMethod();
    }
}