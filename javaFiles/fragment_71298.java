private void setSuit(int suit){
    int suit_num = suit * 13;
    int temp;
    for(int index = 0; index < this.ib.length; index++) {
        temp = suit_num + index;
        BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource (getResources(), card_id[temp],options)                                         
                options.inSampleSize = calculateInSampleSize(options,100,100);//100 and 100 whatever you want as scale
                    options.inJustDecodeBounds = false;
                Bitmap yourSelectedImage = BitmapFactory.decodeResource(getResources(),card_id[temp],options);
           BitmapDrawable ob = new BitmapDrawable(getResources(), yourSelectedImage)
            this.ib[index].setBackgroundDrawable(ob);
    }
}