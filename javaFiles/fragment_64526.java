private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setusename(String usename) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", usename);
        editor.commit();

        }

   }

    public String getusename() {
       return prefs.getString("username","");    
     }
  }