ToggleButton toggle = new ToggleButton();

Service<Void> toggleService = new Service<Void>() {

    @Override
    protected Task<Void> createTask() {

        return new Task<Void>(){

            @Override
            protected Void call() throws Exception {

                while(!isCancelled()) {
                    int randomInt = (int )(Math.random() * 37 + 1);
                    System.out.println(randomInt);
                }
                return null;
            }
        };
    }
};

toggle.selectedProperty().addListener((obs, oldVal, newVal) -> {
    if(newVal) {
        toggleService.reset();
        toggleService.start();
    }
    else 
        toggleService.cancel();

});