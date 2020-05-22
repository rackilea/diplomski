public class WorkerDemo extends JFrame {
    private boolean isStarted = false;
    private JLabel counterLabel = new JLabel("Not started");
    private Worker worker = new Worker();
    private JButton startButton = new JButton(new AbstractAction("Start") {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(!isStarted) { 
                worker.execute();
                isStarted = false;
            }
        }

    });
    private JButton stopButton = new JButton(new AbstractAction("Stop") {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            worker.cancel(true);
        }

    });

    public WorkerDemo() {

        add(startButton, BorderLayout.WEST);
        add(counterLabel, BorderLayout.CENTER);
        add(stopButton, BorderLayout.EAST);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class Worker extends SwingWorker<Void, Integer> {

        int counter = 0;

        @Override
        protected Void doInBackground() throws Exception {
            while(true) {
                counter++;
                publish(counter);
                Thread.sleep(60);
            }
        }

        @Override
        protected void process(List<Integer> chunk) {

            // get last result
            Integer counterChunk = chunk.get(chunk.size()-1);

            counterLabel.setText(counterChunk.toString());
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new WorkerDemo();
            }

        });
    }

}