int currentposition;

listview.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
        currentposition = info.position;
        menu.setHeaderTitle("Choose");
        menu.add(0, v.getId(), 0, "Delete ");

    }

});