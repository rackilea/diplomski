ICalendar icals = new ICalendar();
VEvent event = new VEvent();
event.setDateStart(new Date());
event.setDateEnd(new Date());
event.setDescription("some description");

icals.setProductId("some product ID");
icals.addEvent(event);

WriterChainText text = Biweekly.write(icals);
System.out.println(text.go());