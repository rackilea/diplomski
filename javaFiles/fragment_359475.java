fun getDate(timestamp: Long) :String {
   val calendar = Calendar.getInstance(Locale.ENGLISH)
   calendar.timeInMillis = timestamp * 1000L
   val date = DateFormat.format("dd-MM-yyyy", cal).toString()
   return date;
}