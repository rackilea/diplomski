public class MainFrame extends javax.swing.JFrame implements PropertyChangeListener {

    private final JLabel label = new JLabel();

    MainFrame() {

        setPreferredSize(new Dimension(200, 200));
        add(label);
        pack();

        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                String c = null;
                for (String s : new String[] {"a", "b", "c"}) {
                    Thread.sleep(1000);
                    firePropertyChange("counter", c, c = s);
                }
                return true;
            }
        };

        worker.addPropertyChangeListener(MainFrame.this);
        worker.execute();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if ("counter".equals(evt.getPropertyName())) {
            label.setText((String) evt.getNewValue());
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

}