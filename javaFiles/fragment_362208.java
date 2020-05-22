public class DoubleComparator implements Comparator<DoubleAndString>
{
    public int compare(DoubleAndString ds1, DoubleAndString ds2)
    {
        return Double.compare(ds1.getDouble(), ds2.getDouble());
    }
}