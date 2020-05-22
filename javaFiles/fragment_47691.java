final class Datum {

    final String type;
    final List<DataPoint> dataPoints;

    Datum(final String type, final List<DataPoint> dataPoints) {
        this.type = type;
        this.dataPoints = dataPoints;
    }

}