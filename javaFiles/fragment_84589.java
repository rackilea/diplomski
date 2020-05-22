public static void main(String[] args) {
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLayout(new BorderLayout());
    jFrame.setPreferredSize(new Dimension(500, 500));

    final JFormattedTextField comp = new JFormattedTextField();
    comp.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat(
            "H'h' mm'm'"))));
    comp.setValue(Calendar.getInstance().getTime());

    comp.addPropertyChangeListener("value", new PropertyChangeListener() {

        @Override public void propertyChange(PropertyChangeEvent evt) {
            System.out.println(comp.getValue());

        }
    });

    jFrame.getContentPane().add(comp, BorderLayout.CENTER);

    jFrame.pack();
    jFrame.setVisible(true);
}