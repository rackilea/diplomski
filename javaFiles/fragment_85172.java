Map<String, String> values = new HashMap<>();
    values.put("key0", "value0");
    values.put("key1", "value1");
    values.put("key2", "value2");

    SharedPreferences keyValues = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
    SharedPreferences.Editor keyValuesEditor = keyValues.edit();

    for (String s : values.keySet()) {
        keyValuesEditor.putString(s, values.get(s));
    }

    keyValuesEditor.apply();