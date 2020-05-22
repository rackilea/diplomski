final class Axis {

    @JsonAdapter(RawStringTypeAdapter.class)
    final String labelFormatter;

    Axis(final String labelFormatter) {
        this.labelFormatter = labelFormatter;
    }

}