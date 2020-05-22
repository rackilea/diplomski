public void openDialog(final boolean shouldUpdate, final Bowler bowler, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = View.inflate(this, R.layout.activity_bowlers_dialog, null);

        leagueId = view.findViewById(R.id.tvLeagueId); // <-- Add this line

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(BowlerActivity.this);
        alertDialogBuilderUserInput.setView(view);

        leagueId.setText(savedLeagueId);
        final EditText inputBowler = view.findViewById(R.id.etBowlerName);

        // rest of the code