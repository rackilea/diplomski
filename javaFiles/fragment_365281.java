private void sharePhotoToFacebook(){

  Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.imagebitmap);

  ByteArrayOutputStream stream = new ByteArrayOutputStream();
  icon.compress(Bitmap.CompressFormat.PNG, 100, stream);
  byte[] byteArray = stream.toByteArray();

  Bundle params = new Bundle();


  JSONObject json= new JSONObject();
  try {
     json.put("ProjectionType", "equirectangular");
     json.put("CroppedAreaImageWidthPixels", 5376);
     json.put("CroppedAreaImageHeightPixels", 2688);
     json.put("FullPanoWidthPixels", 5376);
     json.put("FullPanoHeightPixels", 2688);
     json.put("CroppedAreaLeftPixels", 0);
     json.put("CroppedAreaTopPixels", 0);

  } catch (JSONException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
  }


  JSONObject jsonObject=new JSONObject();
  params.putByteArray("picture", byteArray);
  params.putBoolean("allow_spherical_photo", true);
  params.putString("spherical_metadata", json.toString());




  new GraphRequest(
        AccessToken.getCurrentAccessToken(),
        "/me/photos",
        params,
        HttpMethod.POST,
        new GraphRequest.Callback() {
           public void onCompleted(GraphResponse response) {
        /* handle the result */

              Log.e("@@@response", String.valueOf(response));

  Toast.makeText(getApplicationContext(),"Snapshot shared On Facebook",Toast.LENGTH_SHORT).show();


           }
        }
  ).executeAsync();
 }