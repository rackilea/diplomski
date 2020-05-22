Animation anim = AnimationUtils.loadAnimation(
                     GoTransitApp.this, android.R.anim.slide_out_right
                 );
anim.setDuration(500);
listView.getChildAt(index).startAnimation(anim );

new Handler().postDelayed(new Runnable() {

    public void run() {

        FavouritesManager.getInstance().remove(
            FavouritesManager.getInstance().getTripManagerAtIndex(index)
        );
        populateList();
        adapter.notifyDataSetChanged();

    }

}, anim.getDuration());