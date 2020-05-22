for (int i = 0; i < 10; i++) {
        getSharedPreferences("Values" + i, 0).edit().putString("Key" + i, "STring" + i);
    }
    for (int i = 0; i < 10; i++) {
        getSharedPreferences("Values" + i, 0).getString("Key" + i, "");
    }