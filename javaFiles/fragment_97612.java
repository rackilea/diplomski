@Override
protected Dialog onCreateDialog(int id)
{
    switch (id) {

    case 0:
        LayoutInflater factory = LayoutInflater.from(this);

        // Setup of the view for the dialog
        final View bindListDialog = factory.inflate(R.layout.multi_list_layout, null);
        multiListView = (ListView) bindListDialog.findViewById(R.id.multiList);

        // Because I do not know how to properly handle an undo in this situation
        // I make the dialog only close if the button is pressed and confirms the changes
        return new AlertDialog.Builder(MultiSelectDemoActivity.this).setTitle(R.string.multiSelectTitle)
                .setCancelable(false).setView(bindListDialog)
                .setPositiveButton(R.string.btnClose, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        updateItemList(); // In my implementation there is a list view
                                          // that shows what has been selected.
                    }
                }).create();
    default:
        return null;
    }
}

private static final boolean ONCREATE = true;
private static final boolean ONUPDATE = false;

private void setupMultiList(Boolean newList)
{
    demoDBM.open();
    multiCur = demoDBM.getList(userId); // Gets all items tied to the user.
    startManagingCursor(multiCur);
    // Uses the cursor to populate a List item with an invisible ID column,
    // a name column, and the checkbox
    demoDBM.close();

    if (newList)
    {
        // Creates a new adapter to populate the list view on the dialog
        multiAdapter = new SimpleCursorAdapter(this, R.layout.check_list_item, multiCur, new String[] { DemoDBM.ID,
                DemoDBM.NAME, DemoDBM.SEL }, new int[] { R.id.itemId, R.id.itemName, R.id.itemCheck });
        multiAdapter.setViewBinder(new MyViewBinder());
        multiListView.setAdapter(multiAdapter);
    } else
    {
        // updates the previously made adapter with the new cursor, without changing position
        multiAdapter.changeCursor(multiCur);
    }
}

@Override
protected void onPrepareDialog(final int id, final Dialog dialog, Bundle args)
{
    setupMultiList(ONCREATE);
}

public class MyViewBinder implements ViewBinder
{
    @Override
    public boolean setViewValue(View view, Cursor cursor, int columnIndex)
    {
        int checkId = cursor.getColumnIndex(DemoDBM.SEL);

        if (columnIndex == checkId)
        {
            CheckBox cb = (CheckBox) view;
            // Sets checkbox to the value in the cursor
            boolean bChecked = (cursor.getInt(checkId) != 0);
            cb.setChecked(bChecked); // Switches the visual checkbox.

            cb.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
            return true;
        }
        return false;
    }
}

public class MyOnCheckedChangeListener implements OnCheckedChangeListener
{
    @Override
    public void onCheckedChanged(CompoundButton checkBox, boolean newVal)
    {
        View item = (View) checkBox.getParent(); // Gets the plain_list_item(Parent) of the Check Box

        // Gets the DB _id value of the row clicked and updates the Database appropriately.
        int itemId = Integer.valueOf(((TextView) item.findViewById(R.id.itemId)).getText().toString());
        demoDBM.open();
        demoDBM.setChecked(itemId, userId, newVal);
        demoDBM.close();

        setupMultiList(ONUPDATE);
    }
}