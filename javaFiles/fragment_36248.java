//((JSpinner.DefaultEditor) spStartTime.getEditor()).getTextField()
//  .setFormatterFactory(new DefaultFormatterFactory(
//    new DateFormatter(new SimpleDateFormat("hh:mm:ss,SSS"))));
SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss,SSS");
format.setTimeZone(TimeZone.getTimeZone("GMT"));
((JSpinner.DefaultEditor) spStartTime.getEditor()).getTextField()
    .setFormatterFactory(new DefaultFormatterFactory(
      new DateFormatter(format)));