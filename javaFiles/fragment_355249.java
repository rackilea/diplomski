private static SensorSample apply(Map.Entry<Long, List<SensorSample>> e) {
        SensorSample sensorSample = new SensorSample();
        sensorSample.setTimestamp(e.getKey());
        double average = e.getValue().stream()
                .mapToDouble(SensorSample::getSample)
                .average().orElse(0);
        sensorSample.setSample(average);
        sensorSample.setSensorType(e.getValue().get(0).getSensorType());
        return sensorSample;
}