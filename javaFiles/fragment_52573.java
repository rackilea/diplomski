@Override
public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int itemPosition = info.position;

        switch (item.getItemId()) {
            case R.id.contextItem1:

                listViewItems.get(itemPosition).setMarkerAttribute(true);
                listView.setAdapter(new MyCustomListAdapter(context, listViewItems));

                return true;
            case R.id.contextItem2:

//do sth
                return true;
            case R.id.contextItem3:
//do sth
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }