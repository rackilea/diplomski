public class ControlsController {

    private CashRegisterController cashRegisterController ;

    public void setCashRegisterViewController(CashRegisterController cashRegisterController) {
        this.cashRegisterController = cashRegisterController ;
    }

    // existing code...

    private void StartSuperSim(){

        // getCashRegisterController().CreateCashRegisters();

        cashRegisterController.CreateCashRegisters();

        seconds = 0;

        setSuperSim(new Timeline(new KeyFrame(Duration.seconds((1 / controlsModel.getAcceleration())), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds++;
                //System.out.println(seconds);

                if((seconds % (int)controlsModel.getParametersModel().getTimeBetweenCustomers()) == 0){
                    //System.out.println("Fired");
                }
            }
        })));
        getSuperSim().setCycleCount(Timeline.INDEFINITE);
        getSuperSim().play();
    }

    // ...
}