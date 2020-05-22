public void testInsert() {
        Uri CONTENT_URI = Uri.parse("content://" + AddressContentProvider.AUTHORITY + "/address");
        AddressContentProvider addressContentProvider = getProvider();
        ContentValues initialValues = new ContentValues();
    //Uri returnURI = null;
        initialValues.put("country", "USA");
        initialValues.put("region", "test");
        initialValues.put("city", "Jacksonville");
        initialValues.put("state", "FL");
        initialValues.put("zip", "32258");
        initialValues.put("province", "test");
        initialValues.put("geo_location_id", "");
        Uri returnURI = addressContentProvider.insert(CONTENT_URI, initialValues);
        assertTrue(returnURI != null);
}