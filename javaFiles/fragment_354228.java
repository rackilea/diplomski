@DataProvider(name = "dp2", parallel = true)
public Iterator<Object[]> dp2() {
    return FluentIterable.from(this.map.entrySet())
            .transform(new Function<Map.Entry<Integer, String>, Object[]>() {
                @Override
                public Object[] apply(Map.Entry<Integer, String> input) {
                    return new Object[]{input.getKey(), input.getValue()};
                }
            })
            .iterator();

}