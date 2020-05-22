public abstract class BaseButton extends AppCompatButton{

    private ButtonStatus buttonStatus = ButtonStatus.OFF;
    private Image onIcon;
    private Image offIcon;

    public BaseButton (Image onIcon, Image offIcon){
      this.onIcon = onIcon;
      this.offIcon = offIcon;
    }
    public void toggleButton(){
 // ...