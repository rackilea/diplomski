mAdapter.setViewBinder(new ViewBinder() {
        public boolean setViewValue(View aView, Cursor aCursor, int aColumnIndex) {

            //Modification of the icon to display in the list
            if (aColumnIndex == aCursor.getColumnIndex(DatabaseHandler.RATE_EMOTION)) {
                int emotionID = aCursor.getInt(aColumnIndex);
                Drawable emotionDrawable = resources.getDrawable(R.drawable.ic_unknown_rate);

                //if emotion is set
                if(emotionID > 0){
                    String emotionDrawablePath = "ic_smi" + emotionID;          
                    int emotionDrawableID = resources.getIdentifier(emotionDrawablePath,"drawable", getPackageName());
                    //if a drawable is found
                    if(emotionDrawableID > 0){
                        emotionDrawable = resources.getDrawable(emotionDrawableID);
                    }
                }

                ImageView emotionImage = (ImageView) aView;                 
                emotionImage.setImageDrawable(emotionDrawable);
                return true;
            }

            return false;
        }
    });