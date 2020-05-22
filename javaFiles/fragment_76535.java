try {
    JSONObject obj = new JSONObject();
    // crazy stuff that might throw a JSONException
} catch (JSONException e) {

    AlertDialog.Builder alert = new AlertDialog.Builder(context)
        .setTitle(R.string.dialog_title_error)
        .setMessage(R.string.dialog_message_error)
        .setPositiveButton(android.R.string.ok, null);
    alert.show();

}