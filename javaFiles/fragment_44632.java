// No need to cast it to a button here, as it 
findViewById(R.id.one_player).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Log.d("DEBUG", "One Player Button Pressed!");
        Intent intent = new Intent(MainMenuScreen.this, TicTacToeGame.class);
        intent.putExtra("gameType", true);
        startActivityForResult(intent, 0);
    }
});