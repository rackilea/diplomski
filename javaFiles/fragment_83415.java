File imgFile = new File( itemDetailsrrayList.get(position).getImage() ); 
if(imgFile.exists()){
 Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
 ImageView myImage = (ImageView) findViewById(R.id.imageviewTest); 
myImage.setImageBitmap(myBitmap);
 }