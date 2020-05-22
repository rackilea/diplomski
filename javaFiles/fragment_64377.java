@Override
public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
    holder.mTextPar.setText(currentItem.getText2());
    Integer parFromActivity = -1;
    if(ActivityGame.mHoleNm != null) 
        parFromActivity = Integer.parseInt(ActivityGame.mHoleNm.getText().toString());

    /** If persons par number is smaller than course par number, then change persons par number background to blue **/
    if (Integer.parseInt(holder.mTextPar.getText().toString()) < parFromActivity) {
        holder.mTextPar.setBackgroundColor(Color.parseColor("#255eba"));
        // notifyDataSetChanged(); // We do not need this line
    } else if (Integer.parseInt(holder.mTextPar.getText().toString()) > parFromActivity) {
        holder.mTextPar.setBackgroundColor(Color.parseColor("#800080")); // purple maybe
    } else {
        holder.mTextPar.setBackgroundColor(Color.parseColor("#D3D3D3"));
    }
}