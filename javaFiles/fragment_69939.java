UtilDateModel model = new UtilDateModel();
//model.setDate(20,04,2014);
// Need this...
Properties p = new Properties();
p.put("text.today", "Today");
p.put("text.month", "Month");
p.put("text.year", "Year");
JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
// Don't know about the formatter, but there it is...
JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());