public class Class1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Class1::new);
    }

    Class1() {
        JFrame window = new JFrame();
        window.setTitle("Parent frame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1200, 800);
        window.setLocationRelativeTo(null);

        JTabbedPane jtp = new JTabbedPane();
        window.add(jtp);

        window.setVisible(true);

        new Builder(jtp).execute();
    }
}

class Builder extends SwingWorker<Void, CustomJPanel> {
    JTabbedPane jtp;

    Builder(JTabbedPane _jtp) {
        jtp = _jtp;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (int i = 0; i < 500; i++) {
            CustomJPanel panel = new CustomJPanel();
            publish(panel);
        }
        return null;
    }

    @Override
    protected void process(List<CustomJPanel> panels) {
        int i = jtp.getTabCount();
        for (CustomJPanel panel : panels) {
            jtp.addTab("tab" + i, panel);
            i++;
        }
    }
}