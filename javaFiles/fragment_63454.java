Bitmap bm = Bitmap.createBitmap(gestureView.getGesture().toBitmap(100,
        100, 8, Color.WHITE));

ByteArrayOutputStream baos = new ByteArrayOutputStream(2056);
bm.compress(Bitmap.CompressFormat.PNG, 100, baos);

byte[] imageBytes = baos.toByteArray();
String encodedString = Base64.encodeToString(imageBytes, Base64.DEFAULT);