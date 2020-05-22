public class PlayAFriend extends ListActivity {
DBAdapter DBAdapter;
int mChoice;
......
......

@Override
public Dialog onCreateDialog(final int id) {

    final DBAdapter db = new DBAdapter(this);
    db.open();
    switch (id) {
    case 0:
        return new AlertDialog.Builder(this)
        .setIcon(R.drawable.icon)
        .setTitle("Select an Option")
        .setSingleChoiceItems(items, id,
                new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog,
                    int choice) {
                mChoice = choice; // save the choice

            }
        }

                )
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                            int choice) {

                        // TODO Auto-generated method stub

                        if (mChoice == 0) {
                            Toast.makeText(getBaseContext(),
                                    "Test", Toast.LENGTH_SHORT)
                                    .show();
                        } else if (mChoice == 1) {
                            Toast.makeText(getBaseContext(),
                                    "Test2", Toast.LENGTH_SHORT)
                                    .show();

                        } else if (mChoice == 2) {
                            Toast.makeText(getBaseContext(),
                                    "Friend Removed",
                                    Toast.LENGTH_SHORT).show();
                            final TextView friends = (TextView) findViewById(R.id.textview_friends);
                            String deletedfriend = friends
                                    .getText().toString();

                            db.DeleteFriends(deletedfriend);

                        }

                    }

                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                            int choice) {

                    }
                })

                .create();

    }
    return null;
}