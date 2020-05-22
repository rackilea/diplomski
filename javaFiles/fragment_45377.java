// We don't know the type of field, so it's hard to guess the
// type here. Likewise I *would* use the name field, but that's the
// name of the array... it should probably be called fields, as it's
// naturally plural...
for (Object fooField : field) {
    if (fooField instanceof JFormattedTextField) {
        // Again, don't bother with final in Java 8
        final JFormattedTextField textField = (JFormattedTextField) fooField;
        textField.addActionListener(new ActionListener()) {
            @Override public void actionPerformed(ActionEvent e) {
                textField.selectAll();
                // etc
            }
        });
    }
}