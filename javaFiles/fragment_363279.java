ListView listView = getListView();
int position = listView.getFirstVisiblePosition();
if (!(body.trim().equals(""))){
   String bodysplit[] = body.split(",");
   for (int i = 0; i < bodysplit.length; i++) {
      mAdapter.add(bodysplit[i].trim());
   } 
}

listView.setSelection(position);