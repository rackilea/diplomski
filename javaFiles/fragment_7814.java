Collections.sort(li, new Comparator<Number>() {
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
    public int compare(Number o1, Number o2) {
        Double d1 = (o1 == null) ? Double.POSITIVE_INFINITY : o1.doubleValue();
        Double d2 = (o2 == null) ? Double.POSITIVE_INFINITY : o2.doubleValue();

        if (o1 != null && o2 != null) {
            if (!(allowedTypes.contains(o1.getClass()) && allowedTypes.contains(o2.getClass()))) {
                throw new UnsupportedOperationException("Allowed Types:" + allowedTypes);
            }
        }

        return d1.compareTo(d2);

    }
});