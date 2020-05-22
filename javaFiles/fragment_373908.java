for (int i = 0; i < al.size(); i++){
    Bitmap ThumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(
            Environment.getExternalStorageDirectory()+"/ImageSpace/"+al.get(i)), 
                    THUMBSIZE, THUMBSIZE);
    Drawable d = new BitmapDrawable(getResources(),ThumbImage);
    imageView = new ImageView(MainActivity.this);
    imageView.setId(i);
    imageView.setBackground(d);
    //linearLayout1.removeAllViews();
    //imageView.setTag(i+"");
    linearLayout1.addView(imageView);
     imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v1) {

                    System.out.print("Imageview clikcked Path!::::" +al.get(v1.getId()));

                    }

                }
            });
}