class SumDoubles implements Function<Double, Double> {

    @Override
    public Double call(Double... input) {
        Double sum = 0.0;

        for (Double d : input) {
            sum += d;
        }

        return sum;
    }
}

@Test
public void sum() {
    Double sum = runFunction(new SumDoubles(), 1.0, 2.0, 3.0);
    assertThat(sum, is(6.0));
}