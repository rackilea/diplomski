ByteArrayOutputStream stream = new ByteArrayOutputStream();
bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
byte[] image = stream.toByteArray();

Intent intent = new Intent(this, YourActivity.class);
intent.putExtra("photo", image);
startActivity(intent);