localListView.setOnItemClickListener(new OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
              final Intent localIntent = new Intent(RegisterActivity.this, ViewObjectActivity.class);
              localIntent.putExtra("id", objects[position].getId());
              localIntent.putExtra("permission", objects[position].getPermission());
              localIntent.putExtra("lattitude", objects[position].getLattitude());
              localIntent.putExtra("longitude", objects[position].getLongitude());
              startActivityForResult(localIntent, VIEW_SIT_REP_REQUEST);
          }
});