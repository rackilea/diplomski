public class Giraffe
{
    public Giraffe(int heightInFeet)
    {
        this.heightInFeet = heightInFeet;
        this.numberOfSpots = heightInFeet * 72;
    }

    public override string ToString()
    {
        return "Height: " + heightInFeet + " feet"
            + " Number of Spots: " + numberOfSpots;
    }

    private int heightInFeet;
    private int numberOfSpots;
}