xAxis.setValueFormatter(new IAxisValueFormatter() {

    private final SimpleDateFormat mFormat = new SimpleDateFormat("dd MMM HH:mm", Locale.ENGLISH);

    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        long millis = TimeUnit.HOURS.toMillis((long) value);
        return mFormat.format(new Date(millis));
    }
});