public class YourBackingBean {

    private String buttonValue;

    public YourBackingBean() {

       buttonValue = "start";
    }

    public String onBtnClick() {

         buttonValue = buttonValue.equals("start") ? "stop" : "start";
         return null;
    }

    public String getButtonValue() {
         return buttonValue;
    }

    public void setButtonValue(String buttonValue) {
         this.buttonValue = buttonValue;
    }
}