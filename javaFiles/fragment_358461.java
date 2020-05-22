public static void main(final String[] args) {
    // simple window preparation
    final JFrame f = new JFrame();
    f.setBounds(200, 200, 400, 400);
    f.setVisible(true);

    { // this sleep part shall simulate a user doing some stuff
        try { 
            Thread.sleep(2345);
        } catch (final InterruptedException ignore) {}
    }

    { // here's the interesting part for you, this is what you put inside your button listener or whatever
        final JTextField t = new JTextField("Hello World!");
        t.addFocusListener(new FocusListener() {
            @Override public void focusLost(final FocusEvent pE) {}
            @Override public void focusGained(final FocusEvent pE) {
                t.selectAll();
            }
        });
        f.add(t);
        f.validate();

        t.requestFocus();
    }
}