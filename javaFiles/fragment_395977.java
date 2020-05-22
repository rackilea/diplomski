SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

try {

    String reformattedStr = myFormat.format(fromUser.parse(inputString));
} catch (ParseException e) {
    e.printStackTrace();
}