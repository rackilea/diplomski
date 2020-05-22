for (int i = 0; i < 10; i++) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        label2.setLocation(label1.getX() + 10 - label1.getWidth(), label1.getY());
        label1.setLocation(label1.getX() + 10, label1.getY());
        label2.setVisible(true);
    }