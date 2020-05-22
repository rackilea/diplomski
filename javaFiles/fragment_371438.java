SharedPreferences pref;
        SharedPreferences.Editor editor;

     pref = (this.getApplicationContext()).getSharedPreferences("USER_DATA", MODE_PRIVATE);

     editor = pref.edit();
                                            editor.putBoolean("login_status", true);
                                            editor.putString("CODE", "" + String.valueOf(obj.get("code")));
                                            editor.putString("NAME", "" + String.valueOf(obj.get("message")));
                                            editor.putString("USER_ID", "" + String.valueOf(obj.get("user id")));
                                            editor.commit();