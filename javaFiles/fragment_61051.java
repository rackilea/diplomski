for (DataSnapshot alert: alerts.getChildren()) {
  System.out.println(alert.child("date").getValue();
  System.out.println(alert.child("message").getValue();
  for (DataSnapshot recipient: alert.child("recipients").getChildren()) {
    System.out.println(recipient.child("name").getValue();
  }
}