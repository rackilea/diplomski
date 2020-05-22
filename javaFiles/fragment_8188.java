Context ctx = MainActivity.this;       
    SharedPreferences sp = ctx.getSharedPreferences("SP", MODE_PRIVATE);
    Editor editor = sp.edit();
    editor.putString("STRING_KEY", "string");
    editor.putInt("INT_KEY", 0);
    editor.putBoolean("BOOLEAN_KEY", true);
    editor.commit();