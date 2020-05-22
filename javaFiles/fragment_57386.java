protected void onPostExecute(String s) {

    //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    try {
        ArrayList<String> mangLV = new ArrayList<String>();

        JSONArray jsonArray = new JSONArray(s);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            //HoTen.getString("HoTen");
            String HoTen = object.getString("HoTen");
            int NamSinh = object.getInt("NamSinh");
            String DiaChi = object.getString("DiaChi");
            String result = String.format("HoTen: %s, NamSinh: %s, DiaChi: %s",
                    HoTen, NamSinh, DiaChi);
            mangLV.add(result);
        }
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, mangLV);
        lvSinhVien.setAdapter(adapter);
    } catch (JSONException e) {
        e.printStackTrace();
    }
}