private void storeUserPreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putString("username", "xyz");
                editor.putString("pass", "123");
        editor.commit();
    }


private void loadUserPreferences() {
            SharedPreferences sharedPreferences = PreferenceManager
                    .getDefaultSharedPreferences(this);
             String pass =sharedPreferences.getString("pass","");
             String username=sharedPreferences.getString("username","");
             if(!TextUtils.isEmpty(pass)&&!TextUtils.isEmpty(username))
             {
                login.....success
             }
             else
             {
                  redirect to login screen
               }



        }