@Override
public void getResponse(int responseCode, String responseString, String requestType, int requestCode) {
    if (requestCode == FETCH_SHOPS_REQUEST_CODE && responseCode == 200) {

        Gson gson = new Gson();
        Shop[] shops = gson.fromJson(responseString, Shop[].class);
        ArrayList<Shop> tmp = new ArrayList<>(Arrays.asList(shops));
        arrayListShops.addAll(tmp);
        Toast.makeText(this, arrayListShops.size() + " Shops", Toast.LENGTH_SHORT).show();
        adapterShops.notifyDataSetChanged();
    }
}