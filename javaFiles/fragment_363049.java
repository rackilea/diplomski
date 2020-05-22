final JComponent comp = new JPanel(new MyBorderLayout());
comp.add(new JTable(10, 3));
comp.add(new JLabel("east"), BorderLayout.EAST);
comp.add(new JLabel("west"), BorderLayout.WEST);
comp.add(new JLabel("north"), BorderLayout.NORTH);
comp.add(new JLabel("south"), BorderLayout.SOUTH);
ActionListener l = new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        ((MyBorderLayout) comp.getLayout()).paintDebug(comp);
    }

};
showInFrame(comp, "debug");
new Timer(400, l).start();