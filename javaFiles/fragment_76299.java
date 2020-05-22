@Override
public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.playButton.setOnClickListener(new TimeCardButton(context, holder.getAdapterPosition(), holder.buttons).checkStatus());
    holder.editButton.setOnClickListener(new TimeCardButton(context, holder.getAdapterPosition(), holder.buttons).checkStatus());
    holder.pauseButton.setOnClickListener(new TimeCardButton(context, holder.getAdapterPosition(), holder.buttons).checkStatus());
    holder.stopButton.setOnClickListener(new TimeCardButton(context, holder.getAdapterPosition(), holder.buttons).checkStatus());

    // Set the buttons visibility changes here. 
    if(playTrack[position] == 1) { 
        // Item in this position is being played
        playButton.setVisibility(View.INVISIBLE);
        editButton.setVisibility(View.INVISIBLE);
        pauseButton.setVisibility(View.VISIBLE);
        stopButton.setVisibility(View.VISIBLE);

    } else if(playTrack[position] == 0) { 
        // Item in this position is not being played/stopped
        playButton.setVisibility(View.VISIBLE);
        editButton.setVisibility(View.VISIBLE);
        pauseButton.setVisibility(View.INVISIBLE);
        stopButton.setVisibility(View.INVISIBLE);
    } else if(playTrack[position] == 2) { 
        // Item in this position is paused
        playButton.setVisibility(View.VISIBLE);
        editButton.setVisibility(View.INVISIBLE);
        pauseButton.setVisibility(View.INVISIBLE);
        stopButton.setVisibility(View.VISIBLE);
    }
}