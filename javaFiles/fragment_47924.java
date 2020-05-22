public class VendingMachine {
    private FoodType candy;
    private FoodType chips;
    private FoodType sodas;
    private FoodType cookies;

    private static String errorMessage = "A really bad error occurred.";

    public VendingMachine(){
        this.setupMachine();
    }

    private void setUpMachine(){
        this.candy = new FoodType();
        this.chips = new FoodType();
        this.sodas = new FoodType();
        this.cookies = new FoodType();
    }

    private boolean checkInput(){
        if (this.candy==null || this.chips==null || this.sodas==null || this.cookies==null)
            return false;
        else
            return true;
    }

    public void doSomething() throws Exception() {
        if (!this.checkInput()) throw new Exception(VendingMachine.errorMessage);
        // do things
    }
}