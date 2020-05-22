@Override
public void onClick(View view) {
    TimeCard card = MyAdapter.cards.get(position);
    switch (view.getId()) {
        case R.id.playButton:
            startTimer(card);
            trackPlayer[position] = 1;  // Playing
            break;
        case R.id.editButton:
            Intent intent = new Intent(context, TimeCardAdd.class);
            intent.putExtra("cardPosition", position);
            context.startActivity(intent);
            //TODO: Finish the editing so we can modify the timer card
            Toast.makeText(context, "Edit button has been pressed.", Toast.LENGTH_SHORT).show();
            break;

        case R.id.stopButton:
            stopTimer(card);
            trackPlayer[position] = 0;  // Stopped
            break;

        case R.id.pauseButton:
            pauseTimer(card);
            trackPlayer[position] = 2;  // Paused
            break;
    }
}