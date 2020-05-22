fun getDisplayDateTime(dateTimePhp: String): String {
    try {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss",     Locale.getDefault())
        val date = simpleDateFormat.parse(dateTimePhp)
        val convetDateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.getDefault())
        return convetDateFormat.format(date)
    } catch (e: Exception) {
        return ""
    }
}