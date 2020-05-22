String sFirstname = "Tope";
String sLastname = "Adebodun";

Intent theIntent = new Intent(MainActivity.this, ReceivingActivity.class);
theIntent.putExtra("firstname", sFirstname);
theIntent.putExtra("lastname", sLastname);