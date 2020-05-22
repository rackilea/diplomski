// In your activity's onCreate method
try {
    JSONObject obj = new JSONObject(strJSON);
    new postJSON() {

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }

    }.execute("https://www.placeholder.com/generate_json", obj.toString());
} catch (Throwable t) {
    Log.e("JSON Error", "Could not parse malformed JSON: " + strJSON);
}