Button button= (Button) findViewById(R.id.NextButton);
button.setOnClickListener(new OnClickListener() {

    @Override
public void onClick(View v)  {
        // TODO Auto-generated method stub
        Log.i("APP: ", "Into OnClick of SettingDialog. View = " + v);
        eqhist(bmInImg.getHeight(),bmInImg.getWidth(), mPhotoIntArray, mCannyOutArray); 
        Bitmap bmOutImg = Bitmap.createBitmap(bmInImg.getWidth(), bmInImg.getHeight(), Config.ARGB_8888);  
        bmOutImg.setPixels(mCannyOutArray, 0, bmInImg.getWidth(), 0, 0, bmInImg.getWidth(), bmInImg.getHeight());   
        imageview_2.setImageBitmap(bmOutImg);


    }
    });