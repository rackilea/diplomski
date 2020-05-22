public class CircleCompare implements Comparator<Circle>
{
    public int compare(Circle c1, Circle c2){
        return Integer.compare(c1.getRadius(), c2.getRadius());
    }
}