public class SwingWorkerExample  {

    public static class ProgressSimulatorSwingWoker extends SwingWorker<Void, Void> {

        private BoundedRangeModel progressModel;

        public ProgressSimulatorSwingWoker(BoundedRangeModel progressModel) {
            this.progressModel = progressModel;
        }

        @Override
        protected Void doInBackground() throws Exception {
            int start = 0;
            int end = 100;

            progressModel.setMinimum(start);
            progressModel.setMaximum(end);

            for (int i = start; i <= end; i++) {
                progressModel.setValue(i);
                Thread.sleep(50);
            }
            return null;
        }

    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("SwingWorker example");
        jFrame.setSize(640, 150);
        jFrame.setLocationRelativeTo(null); // center on screen
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = jFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JProgressBar jProgressBar = new JProgressBar();
        final BoundedRangeModel model = jProgressBar.getModel();

        JButton jButton = new JButton("Simulate Progress");
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ProgressSimulatorSwingWoker progressSimulatorSwingWoker = new ProgressSimulatorSwingWoker(model);
                progressSimulatorSwingWoker.execute();

            }
        });

        contentPane.add(jProgressBar, BorderLayout.CENTER);
        contentPane.add(jButton, BorderLayout.SOUTH);

        jFrame.setVisible(true);
    }
}