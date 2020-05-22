/**
 *
 * @author blj0011
 */
public class CustomWord
{

    private int distance;
    private String word;

    public CustomWord(int distance, String word)
    {
        this.distance = distance;
        this.word = word;
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public int getDistance()
    {
        return distance;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    @Override
    public String toString()
    {
        return "CustomWord{" + "distance=" + distance + ", word=" + word + '}';
    }
}