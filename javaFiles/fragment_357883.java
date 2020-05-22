public class Model {

    private Observable<Boolean> buttonPressed;

    public Boolean isButtonPressed(){
        return buttonPressed.get();
    }

    public void setButtonPressed(Boolean pressed){
        this.buttonPressed.set(pressed);
    }

    public Observable<Boolean> buttonPressedProperty(){
        return this.buttonPressed;
    }
}