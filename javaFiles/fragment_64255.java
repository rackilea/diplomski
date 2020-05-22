class Util{

    public static boolean validateUserToken(Context context) {

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.user_file_key), Context.MODE_PRIVATE); // This is where the error is thrown
        String accessToken = sharedPref.getString(context.getString(context.R.string.user_access_token), null);
        DateTime expiryDate = new DateTime(sharedPref.getLong(context.getString(R.string.user_expires), 0));

        if (accessToken == null || expiryDate.isBeforeNow()) {
            return false;
        } else {
            return true;
        }
    }
}