public class WorkerPauseManagerTest {
    public static void main(String[] args) {
        final WorkerPauseManager pauseManager = new WorkerPauseManager();
        new Worker("Worker 1", pauseManager).start();
        new Worker("Worker 2", pauseManager).start();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JToggleButton playPauseButton = new JToggleButton(new AbstractAction("Pause") {
                    public void actionPerformed(final ActionEvent e) {
                        JToggleButton source = (JToggleButton) e.getSource();
                        if (source.isSelected()) {
                            pauseManager.start();
                            source.setText("Pause");
                        } else {
                            pauseManager.pause();
                            source.setText("Play");
                        }
                    }
                });
                JOptionPane.showMessageDialog(null, playPauseButton, "WorkerPauseManager Demo", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        });

    }

    private static class Worker extends Thread {
        final String name;
        final WorkerPauseManager pauseManager;

        public Worker(final String name, final WorkerPauseManager pauseManager) {
            this.name = name;
            this.pauseManager = pauseManager;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    pauseManager.pauseIfNeeded();
                    System.out.println(name + " is running");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}