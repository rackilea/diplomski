public class Teller implements Comparable
{

    private boolean ccw = false;
    private int rating;

    public boolean hasCCW() { return ccw; }
    public int getRating() { return rating; }

    //... your code

    @Override
    public int compareTo(Object o) 
    {
        Teller that = (Teller)o;
        //if this has ccw and that doesn't, this < that
        if(this.hasCCW() && !that.hasCCW()) 
        {
            return -1;
        }
        //else if this does not have ccw, and that does, this > that
        else if(!this.hasCCW() && that.hasCCW())
        {
            return 1;
        }
        //else they both have ccw, so compare ratings
        else
        {
            return Integer.compare(this.getRating(), that.getRating());
        }
    }

}