public static<T extends Number,K extends Number> double inner_product(Vector<T> v1, Vector<K> v2)
{
    double isum = 0;
    for(int i=0;i<v1.size()&&i<v2.size();i++)
    {
        isum+=v1.elementAt(i).doubleValue()*v2.elementAt(i).doubleValue();
    }

    return isum;
}