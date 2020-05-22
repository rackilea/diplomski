public void mouseClicked(MouseEvent e) {
    new Thread(new Runnable() {
        layerUI.start();
        // response imitation from server
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        layerUI.stop();
    }).start();
}