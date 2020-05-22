button.setOnClickListener(new OnClickListener() {
  @Override
  public void onClick(View v)  {  
    negative(bmInImg.getHeight(),bmInImg.getWidth(), mPhotoIntArray, mCannyOutArray);
    bmOutImg.setPixels(mCannyOutArray, 0, bmInImg.getWidth(), 0, 0, 
        bmInImg.getWidth(), bmInImg.getHeight());   
    imageview_2.setImageBitmap(bmOutImg);
  }
}); // <-- close the OnClickListener