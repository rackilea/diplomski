//Interface to get custom values for X-axis
    IAxisValueFormatter formatter = new IAxisValueFormatter() {
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timestampList.get((int) value));
            int month = calendar.get(Calendar.MONTH);
            calendar.set(Calendar.MONTH, month);
            return new SimpleDateFormat("MMM").format(calendar.getTime());            }
    };