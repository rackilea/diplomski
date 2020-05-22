public class EditPlayers extends SherlockFragmentActivity implements EditPlayerAdapterCallback {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EditPlayerAdapter adapter = new EditPlayerAdapter(this,
                R.layout.score_row_edit_player, listScoreEdit);
        adapter.setCallback(this);
        listPlayerNames.setAdapter(adapter);

    }

    private void deletePlayer(final int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                EditPlayers.this);

        // Setting Dialog Title
        alertDialog.setTitle("Delete Player");

        // Setting Dialog Message
        alertDialog.setMessage("Are you sure?");

        // Setting Delete Button
        alertDialog.setPositiveButton("Delete",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        listScoreEdit.remove(position);
                        updateListView();
                    }
                });

        // Setting Cancel Button
        alertDialog.setNeutralButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        // Showing Alert Message
        alertDialog.show();
    }

    @Override
    public void deletePressed(int position) {

        deletePlayer(position);
    }

}