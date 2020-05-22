public class T {

static int threadNumber = 0;

public static void main(String[] args) throws Exception {

    final JTable table = new JTable(new DefaultTableModel(new Object[] { "Thread Name", "Progress" }, 0));

    JButton btnBegin = new JButton("Begin");
    btnBegin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            MyThreadClass newThread = new MyThreadClass(model, threadNumber++);
            newThread.start();

            model.addRow(new Object[] { "Thread " + threadNumber, "Column 2" });
        }
    });

    JFrame frame = new JFrame();
    frame.add(btnBegin, BorderLayout.NORTH);
    frame.add(table);
    frame.setSize(400, 400);
    frame.setVisible(true);
}

static class MyThreadClass extends Thread {
    private final DefaultTableModel model;
    private final int threadNumber;

    public MyThreadClass(DefaultTableModel model, int threadNumber) {
        super();
        this.model = model;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    model.setValueAt(index * 20, threadNumber, 1);
                }
            });
        }
    }
}