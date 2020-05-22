@Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, DisplayActivity.class);

        DashboardItems temp = (DashboardItems) adapterView.getItemAtPosition(i);
        //intent.putExtra("DashboardImage",temp.imageID);
        intent.putExtra("DashItemName",temp.itemName);
        startActivity(intent);
    }