...
Drawable myDrawable = getResources().getDrawable(R.drawable.descarga);
Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
ByteArrayOutputStream myLogoStream = new ByteArrayOutputStream();
myLogo.compress(Bitmap.CompressFormat.PNG, 100, myLogoStream);
byte[] myLogoByteArray = myLogoStream.toByteArray();
myLogo.recycle();
ParseFile myLogoFile = new ParseFile("mylogo.png", myLogoByteArray);
grabarImagenPrinc.put("imagen7", myLogoFile);
...