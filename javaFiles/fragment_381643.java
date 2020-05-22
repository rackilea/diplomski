String message = "Score: " + Score + " High Score: " + highScore;
if(Score > highScore) {
    message = "You have set a new high score: " + highScore;
}
AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setMessage(message)
        .setPositiveButton(R.string.returnString, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getActivity(), GameState.class);
                startActivity(intent);
            }
        });
return builder.create();