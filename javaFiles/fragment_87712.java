public void monitor() {
    task1 = new Task<Void>() {
        @Override
        protected Void call() {
            System.out.println("run called");
            int i = 1;
            while (true) {
                try {
                    Thread.sleep(1000);
                    updateMessage(i + ".png");
                    System.out.println("i: " + i);
                } catch (Exception e) {

                }
                i++;
            }
        }
    };
    task1.messageProperty().addListener((observable, oldValue, newValue) -> {
        System.out.println(newValue);
        Image image = new Image(getClass().getResourceAsStream("images/" + newValue));
        imv.setImage(image);
    });
}