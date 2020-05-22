private BooleanBinding done ;

public void doIt(ActionEvent event){
    Button doitButton = ((Button) event.getSource() );
    doitButton.setDisable( true );
    ExecutorService es = Executors.newFixedThreadPool(2);
    final ServiceExample service1 = new ServiceExample(4000);
    final ServiceExample service2 = new ServiceExample(5000);
    service1.setExecutor( es );
    service2.setExecutor( es );

   done = 
        service1.stateProperty().isEqualTo(Worker.State.SUCCEEDED)
        .and(service2.stateProperty().isEqualTo(Worker.State.SUCCEEDED));

    done.addListener((obs, wasDone, isNowDone) -> {
        if (isNowDone.booleanValue()) {
            lbl_Status.setText( "thread1Result: " +  service1.getValue() + "thread2Result: " + service2.getValue() );
            doitButton.setDisable(false);
        }
    });

    service1.start();
    service2.start();
}