APdatabaseClass mDbHelper = new APdatabaseClass(getActivity());
mDbHelper.open();

Cursor c = fetchListData();
getActivity().startManagingCursor(c);

String[] from = new String[] { TableRegistry.TYPE, TableRegistry.DATE, TableRegistry.STATUS };
int[] to = new int[] {  R.id.Text1, R.id.Text2, R.id.Text3  };
SimpleCursorAdapter data = new SimpleCursorAdapter(getActivity(), R.layout.yourlistlayout, c, from, to);
setListAdapter(data);