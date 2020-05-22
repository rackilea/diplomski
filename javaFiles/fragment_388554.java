Sendables sendables = new Sendables();
sendables.add(new EmailController());
sendables.add(new SmsController());
sendables.add(new ChatController());
// etc.


Row row = table.getRow(...); // let's assume this gets a row from your table
sendables.send(row.getId());