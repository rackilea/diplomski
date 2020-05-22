private static final long FIFTEEN_MINS_IN_MILLI_SECONDS = 900_000L;

public static void main(String[] args) {
    //This is just to get some realistic times
    long now = System.currentTimeMillis();
    List<DataPoint> data = getDataPoints(now);

    ArrayList<DataPoint> newDataPoints = data.stream().collect(Collector.of(
            ArrayList<DataPoint>::new,
            (ArrayList<DataPoint> dataPoints, DataPoint nextDataPoint) -> {
                if (!dataPoints.isEmpty()) {
                    addPointIfRequired(dataPoints, nextDataPoint);
                }

                dataPoints.add(nextDataPoint);
            },
            (dataPoints, dataPoints2) -> {
                if (dataPoints.isEmpty()) return dataPoints2;

                if (!dataPoints2.isEmpty()) {
                    addPointIfRequired(dataPoints, dataPoints2.get(0));
                    dataPoints.addAll(dataPoints2);
                }

                return dataPoints;
            }
    ));

    newDataPoints.forEach(System.out::println);
}

private static void addPointIfRequired(ArrayList<DataPoint> dataPoints, DataPoint nextDataPoint) {
    DataPoint previousDataPoint = dataPoints.get(dataPoints.size() - 1);
    long timestampDiff = nextDataPoint.timestamp - previousDataPoint.timestamp;

    if (timestampDiff > FIFTEEN_MINS_IN_MILLI_SECONDS) {
        long fifteenMinIncrement = previousDataPoint.timestamp + FIFTEEN_MINS_IN_MILLI_SECONDS;
        DataPoint newEntry = new DataPoint(previousDataPoint.data, fifteenMinIncrement);
        dataPoints.add(newEntry);
    }
}

private static List<DataPoint> getDataPoints(long now) {
    return Arrays.asList(
            //initial time
            new DataPoint("A", now),
            //15 minute increment
            new DataPoint("B", now + FIFTEEN_MINS_IN_MILLI_SECONDS),
            //15 minute increment
            new DataPoint("C", now + (FIFTEEN_MINS_IN_MILLI_SECONDS * 2)),
            //30 minute increment
            new DataPoint("D", now + (FIFTEEN_MINS_IN_MILLI_SECONDS * 4)),
            //15 minute increment
            new DataPoint("E", now + (FIFTEEN_MINS_IN_MILLI_SECONDS * 5)),
            //30 minute increment
            new DataPoint("F", now + (FIFTEEN_MINS_IN_MILLI_SECONDS * 7))
    );
}

private static class DataPoint {
    private final String data;
    private final long timestamp;

    private DataPoint(String data, long timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return data + " " + Instant.ofEpochMilli(timestamp);
    }
}