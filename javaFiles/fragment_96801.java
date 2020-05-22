public class MyButton extends JButton {
  public String getTooltip() {
     if (this.isEnabled()) {
       return super.getTooltip();
     }
     return null;
  }
}