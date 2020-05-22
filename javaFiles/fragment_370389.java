public class Big extends JFrame implements ActionListener {
    ...

    public Big() {
        createGUI();
    }

    protected void createGUI() {
        // Init buttons of Big here.
    }
}

public class Small extends Big {
    // This constructor is optional; if you remove it, the
    // compiler will insert one that looks exactly like this.
    public Small() {
        super();
    }

    @Override
    protected void createGUI() {
        // Init buttons of Small here.
        // Big's constructor calls this method, but it has been overridden,
        // so Big's implementation of this method will not execute for
        // instances of Small (unless you call super.createGUI(); on purpose).
    }
}