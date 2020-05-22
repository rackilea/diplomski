public void showAudio(View view) {
        if (!audioButtonClicked) {
            audioButtonClicked = true;
            eventButtonClicked = false;
            moreButtonClicked = false;
            audioWindowButton.setImageResource(R.drawable.audio_active);
            eventWindowButton.setImageResource(R.drawable.event_inactive);
            moreWindowButton.setImageResource(R.drawable.event_inactive);
        } else {
            audioWindowButton.setImageResource(R.drawable.audio_inactive);
            audioButtonClicked = false;
        }
}

public void showEvents(View view) {
        if(!eventButtonClicked ) {
            audioButtonClicked = false;
            eventButtonClicked = true;
            moreButtonClicked = false;
            audioWindowButton.setImageResource(R.drawable.audio_inactive);
            eventWindowButton.setImageResource(R.drawable.event_active);
            moreWindowButton.setImageResource(R.drawable.event_inactive);
        } else {
           eventWindowButton.setImageResource(R.drawable.event_inactive);
           eventButtonClicked = false;
        }
}

public void showMore(View view) {
        if(!moreButtonClicked) {
            audioButtonClicked = false;
            eventButtonClicked = false;
            moreButtonClicked = true;
            audioWindowButton.setImageResource(R.drawable.audio_inactive);
            eventWindowButton.setImageResource(R.drawable.event_inactive);
            moreWindowButton.setImageResource(R.drawable.event_active);

        } else {
            moreWindowButton.setImageResource(R.drawable.event_inactive);
            moreButtonClicked = false;
        }
}