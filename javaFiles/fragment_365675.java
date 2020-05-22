public class GPSCoordinate {

    private double verticalcoord;
    private double horizontalcoord;

    //Constructors
    GPSCoordinate(){
        setVertical(0);
        setHorizontal(0);
    }

    GPSCoordinate(double vert, double horiz){
        setVertical(vert);
        setHorizontal(horiz);
    }

    //Display methods
    public String verticalString(){
        return ((int)verticalcoord / 60) + "°" + (verticalcoord - ((int)verticalcoord / 60) *60);
    }

    public String horizontalString(){
        return ((int)horizontalcoord / 60) + "°" + (horizontalcoord - ((int)horizontalcoord / 60) *60);
    }

    //Setting Methods
    public void setVertical(double x){
        this.verticalcoord = x;
    }

    public void setHorizontal(double x){
        this.horizontalcoord = x;
    }

    //Math Methods
    public void addMinutesVertical(double x){
        this.verticalcoord += x;
    }
}