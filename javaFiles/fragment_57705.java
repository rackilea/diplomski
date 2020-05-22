public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {
    //Your code here..
    Map<String, String> myValueMap = menuItems.get(position);

    // Starting new intent
    Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
    in.putExtra(KEY_USERADDRESS, myValueMap.get(KEY_USERADDRESS));
    in.putExtra(KEY_DATEDUE, myValueMap.get(KEY_DATEDUE));
    in.putExtra(KEY_DESC, myValueMap.get(KEY_DESC));
    startActivity(in);
}