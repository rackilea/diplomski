//Somewhere in oncreate .. Not required if xml has onclick specified
Button play_button = (Button)this.findViewById(playIdInt);
play_button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
       increment();
    }
});


public void increment (View view){
       quantity = quantity + 1;
       display(quantity);
       mediaPlayer("mariocoin", "plus_button");
}

// This method calls mediaPlayer
public void mediaPlayer (String sound, String id){
            Uri uriPlayer = Uri.parse("android.resource://" + getPackageName() + "/raw/" + sound );
            final MediaPlayer mp = MediaPlayer.create(this, uriPlayer);
            mp.start();
        }