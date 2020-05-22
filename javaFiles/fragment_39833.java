private Runnable runnable = new Runnable() {
    public void run() {
        myslideshow();
        handler.postDelayed(this, 1000);\\execute every second.
    }
};

    private void myslideshow()
    {
                    PicPosition = gallery.getSelectedItemPosition() +1;             
                    if (PicPosition >=  Pictures.size())            
                    PicPosition =  gallery.getSelectedItemPosition(); //stop 
                                    else
                    gallery.setSelection(PicPosition);//move to the next gallery element.
    }