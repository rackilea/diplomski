SharedPreferences pref;
            SharedPreferences.Editor editor;

         pref = (this.getApplicationContext()).getSharedPreferences("USER_DATA", MODE_PRIVATE);

String name = pref.getString("NAME", "");
String userId = pref.getString("USER_ID", "");
String address = pref.getString("ADDRESS", "");
String phone= pref.getString("PHONE", "");