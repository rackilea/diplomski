class MyClient
{
    public static void main(String[] argv)
    {
        Sequence<Integer> intSeq = new Sequence<Integer>();
        intSeq.set(0,0);
        intSeq.set(1,1);
        int intValue = intSeq.get(1);
        // ...
        Integer[] intArray = intSeq.subArray(1,1);

        Sequence<Double>  doubleSeq = new Sequence<Double>();
        doubleSeq.set(0,1.1);
        doubleSeq.set(1,2.2);
        double doubleValue=doubleSeq.get(1);
        // ...
        Double[] doubleArray = doubleSeq.subArray(1,1);
    }        
}