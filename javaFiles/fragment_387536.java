@Override
 protected void onPostExecute(String result) {

   MainActivity.editor.putString("auth_token", result);
   MainActivity.editor.commit();

   Log.d("token", MainActivity.settings.getString("auth_token", "Nothing"));
   ((MainActivity) context).update();

  }