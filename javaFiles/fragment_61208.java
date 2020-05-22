public class CircleCompare implements Comparator<Circle>
{
    public int compare(Circle c1, Circle c2){
        return c2.getRadius() - c1.getRadius();
    }
}