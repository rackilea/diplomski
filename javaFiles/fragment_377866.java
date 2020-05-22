private int compareNumbers(Number n1, Number n2)
    {
        Double n2c = n2.doubleValue();
        Double n1c = n1.doubleValue();

        return n1c.compareTo(n2c);
    }

    public static void main (String[] args)
    {
        Integer n1 = new Integer(432);
        Long n2 = new Long(40);
        Double n3 = new Double(500.12);

        System.out.println(compareNumbers(n1,n2));
    }