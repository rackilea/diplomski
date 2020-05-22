protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK) {
        Bundle d = data.getExtras();
        String oil = d.getString("oil");
        Resources res = getResources();
        int id = res.getIdentifier(oil, "array", getPackageName());
        String[] oil_info = res.getStringArray(id);
        ...
    } 
}