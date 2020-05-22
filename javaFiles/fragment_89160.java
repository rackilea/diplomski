public void loadData(Context context) {
        if (mNameList == null) {
            mNameList = new ArrayList<>();
        }

        //SharedPreferences prefs = getApplicationContext().getSharedPreferences("shared preference", Context.MODE_PRIVATE);
        SharedPreferences prefs = context.getSharedPreferences("shared preference", Context.MODE_PRIVATE);
        try {
            mNameList = (ArrayList<NameItem>) ObjectSerializer.deserialize(prefs.getString("SharedPrefKey", ObjectSerializer.serialize(new ArrayList<NameItem>())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }