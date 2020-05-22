public class Skip30kFilter {

    @Override
    public boolean equals(Object other) {

        double value = (Double) other;
        return value > -30000.0;
    }
}