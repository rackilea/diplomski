morpionbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (decide == checkedplayer){
            Clean();
            deleteplayer();

            Intent play = new Intent(mContext, Play.class);
            mContext.startActivity(play);
        }
        else {
            Clean();
            deleteplayer();

            Intent play = new Intent(mContext, MorpionAI.class);
            mContext.startActivity(play);
        }
    }
});