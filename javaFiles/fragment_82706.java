String stringData = etNewListName.getText().toString();
        someData = getSharedPreferences(filename,0);
        SharedPreferences.Editor editor = someData.edit();
        editor.putString("sharedString", stringData);
        editor.commit();


        String dataReturned = someData.getString("SharedString", "Unable to Load Data");
        tvResults.setText(dataReturned);