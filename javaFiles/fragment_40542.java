SharedPreferences sharedPref = context.getSharedPreferences("text1",
                Context.MODE_PRIVATE);
        Editor editor = sharedPref.edit();
        if (phone!= null) {
            editor.putString("phone", phone);
        }
editor.commit();