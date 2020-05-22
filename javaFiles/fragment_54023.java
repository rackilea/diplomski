public static String getFrameResult() throws InterruptedException {
    if (SwingUtilities.isEventDispatchThread()) {
        throw new IllegalStateException("Can't be called from EDT.");
    }
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Hello");
        JButton button = new JButton("Done");
        button.addActionListener((ActionEvent e) -> {
            String result = "Done at : " + LocalDateTime.now();
            queue.offer(result);
            frame.dispose();
        });
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    });
    return queue.take();
}