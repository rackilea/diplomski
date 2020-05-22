SharedPreferences pref;
            SharedPreferences.Editor editor;

         pref = (this.getApplicationContext()).getSharedPreferences("USER_DATA", MODE_PRIVATE);



                                                editor.putString("ADDRESS", "" + String.valueOf(obj.get("message")));
                                                editor.putString("PHONE", "" + String.valueOf(obj.get("user id")));
                                                editor.commit();