public void addPlayers(EditText nameOfPlayer, LinearLayout container,
    final List<String> playersNames) {
    final View addView;
    LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    if (nameOfPlayer.getText().length() >= shortestNameLength) {
        addView = layoutInflater.inflate(R.layout.activity_to_add_more_players,
            null);
        TextView textOut = (TextView) addView.findViewById(R.id.textout);
        final String currentName = nameOfPlayer.getText().toString();
        textOut.setText(currentName);
        playersNames.add(currentName);

        nameOfPlayer.setText("");
        Button buttonRemove = (Button) addView.findViewById(R.id.remove);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // removing the name from the List
                playersNames.remove(currentName);

                ((LinearLayout) addView.getParent()).removeView(addView);
            }
        });
        container.addView(addView);
    }
}