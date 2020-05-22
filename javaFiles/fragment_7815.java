List<Number> li = Constraints.constrainedList(new ArrayList<Number>(),
    new Constraint<Number>() {
        HashSet<Class<? extends Number>> allowedTypes;
        {
            allowedTypes = new HashSet<Class<? extends Number>>();
            allowedTypes.add(Integer.class);
            allowedTypes.add(Double.class);
            allowedTypes.add(Float.class);
            allowedTypes.add(Short.class);
            allowedTypes.add(Byte.class);

        }

        @Override
        public Number checkElement(Number arg0) {
            if (arg0 != null) {
                if (allowedTypes.contains(arg0.getClass())) {
                    return arg0;
                }
            }

            throw new IllegalArgumentException("Type Not Allowed");
        }
    }
);

li.add(Double.POSITIVE_INFINITY);
li.add(new Integer(20));
li.add(new Double(12.2));
li.add(new Float(1.2));
li.add(Double.NEGATIVE_INFINITY);
li.add(Float.NEGATIVE_INFINITY);
// li.add(null); //throws exception
// li.add(new BigInteger("22"); //throws exception
li.add(new Integer(20));
System.out.println(li);

Collections.sort(li, new Comparator<Number>() {
    @Override
    public int compare(Number o1, Number o2) {
        Double d1 = o1.doubleValue();
        Double d2 = o2.doubleValue();

        return d1.compareTo(d2);
    }
});

System.out.println(li);