webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
    @Override
    public void changed(ObservableValue<? extends Worker.State> ov, Worker.State t, Worker.State t1) {
        if (t1 == Worker.State.SUCCEEDED) {
            try {
                System.out.println("trying to execute script");

                // fixed - innerHtml is a property, not a function
                String content = (String)webEngine.executeScript("document.getElementById('articleHeader').innerHTML");
                System.out.println(content);
                System.out.println("script successful");
            } catch (Exception e) {

                // you can also print the exception to diagnose the error
                e.printStackTrace();
                System.out.println("script failed");
            }
        }
    }
});