public class AirConditioner{

    private boolean isOn;
    private int temp;

    public AirConditioner(){
        this.isOn = false;
        temp = 0;
    }

    public void turnOn(){
        this.isOn = true;
    }

    public void turnOff(){
        this.isOn = false;
    }

}