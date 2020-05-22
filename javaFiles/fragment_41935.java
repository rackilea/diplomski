class FourFans extends JPanel {

    public FourFans() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new Fan());
        panel.add(new Fan());
        panel.add(new Fan());
        panel.add(new Fan());
    }

}