public class Descriptor {

    private int fromAge;
    private int tillAge;
    private float beginner;
    private float regular;
    private float pro;

    // CONSTRUCTORS

    public Descriptor() {}

    public Descriptor(int fromAge, int tillAge, float beginner, float regular, float pro) {
        this.fromAge = fromAge;
        this.tillAge = tillAge;
        this.beginner = beginner;
        this.regular = regular;
        this.pro = pro;
    }

    // SETTER

    public void setTillAge(int tillAge) {
        this.tillAge = tillAge;
    }

    public void setFromAge(int fromAge) {
        this.fromAge = fromAge;
    }

    public void setBeginner(float beginner) {
        this.beginner = beginner;
    }

    public void setRegular(float regular) {
        this.regular = regular;
    }

    public void setPro(float pro) {
        this.pro = pro;
    }

    // GETTER

    public int getTillAge() {
        return tillAge;
    }

    public int getFromAge() {
        return fromAge;
    }

    public float getBeginner() {
        return beginner;
    }

    public float getRegular() {
        return regular;
    }

    public float getPro() {
        return pro;
    }

}