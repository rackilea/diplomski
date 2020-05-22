Calendar cal = Calendar.getInstance(Locale.ENGLISH);

try {
    cal.setTimeInMillis(Long.parseLong(timestamp)); 
} catch(Exception ex) {
    ex.printStackTrace();
}

String dateTime = android.text.format.DateFormat.format("dd/MM/yyyy hh:mm aa", cal).toString();