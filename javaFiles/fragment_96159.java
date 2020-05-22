@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    // Use the Builder class for convenient dialog construction
    Snooker_Scoreboard ss = new Snooker_Scoreboard();
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setCancelable(false);
    builder.setMessage(ss.winnerPlayer + " won the match ("+ss.frame1ToPass+"-"+ss.frame2ToPass+")!")
            .setPositiveButton("New Match!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent i = new Intent(getContext(),PlayerSelection.class);
                    startActivity(i);
                }
            });



    // Create the AlertDialog object and return it
    Dialog dialog = builder.create();
    dialog.setCanceledOnTouchOutside(false);         
    return dialog;
}