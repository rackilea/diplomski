JCheckBox box = new JCheckBox();
box.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getModifiers() == 0) {
            System.out.println("keyboard");
        } else {
            System.out.println("mouse");
        }
    }
});