public View getView(final int position, ...) {
    if(playingIndex == position)
       songPlayButton.setImageResource(R.drawable.ic_play_black_24dp);
    else
       songPlayButton.setImageResource(R.drawable.ic_pause_black_24dp);

    songPlayButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(position == playIndex)
                playIndex = -1;
            else
                playIndex = position;
            notifyDataSetChanged();
        }
    });
}