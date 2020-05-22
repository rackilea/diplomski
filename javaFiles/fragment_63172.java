@Override
public void onBindViewHolder(MyViewHolder holder, int position) {
    EventNameModel movie = eventNameList.get(position);
    holder.eventNameText.setText(movie.getEventName());
    if(movie.isRadioOn()){
        holder.imageViewRadio.setImageResource(R.drawable.radio_button_on);
    } else {
        holder.imageViewRadio.setImageResource(R.drawable.radio_button_off);
    }
}