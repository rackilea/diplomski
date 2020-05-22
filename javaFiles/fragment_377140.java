JFrame frame = new JFrame();
JProgressBar progressbar = new JProgressBar(0, 100);
frame.setSize(450, 450);
frame.setResizable(true);
frame.setLocationRelativeTo(null);
frame.add(new JLabel(new ImageIcon("C://Users//Alex//Desktop//Image.jpg")), BorderLayout.CENTER);
frame.add(progressbar, BorderLayout.SOUTH);
frame.setTitle("Loading...");
frame.setVisible(true);

Thread loadingThread = new Thread(new Runnable(){
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                //exception
            }
            progressbar.setValue(i);
        }
        frame.dispose();
    }
});
loadingThread.start();