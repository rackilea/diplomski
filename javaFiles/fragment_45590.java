public class YourApplicationClass extends Application{
    private YourCustomClass yourCustomClass;

    public YourCustomClass getYourCustomClass() {
        if (yourCustomClass == null) {
            yourCustomClass = new YourCustomClass();
        }
        return yourCustomClass;
    }

    public void setYourCustomClass(YourCustomClass yourCustomClass) {
        this.yourCustomClass = yourCustomClass;
    }

}