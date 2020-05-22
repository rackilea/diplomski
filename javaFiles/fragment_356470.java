private void imagedata(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        // Must compress the Image to reduce image size to make upload easy
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byte_arr = stream.toByteArray();
        // Encode Image to String
        image_data = Base64.encodeToString(byte_arr, 0);
        byteDrawableList.add(new ByteDrawable(image_data));

        listAdapter = new CustomAdapter(this);
        listView.setAdapter(listAdapter );
    }

    public class ByteDrawable {
        String imageAsBytes;
        public ByteDrawable(String imageAsBytes) {
            this.imageAsBytes = imageAsBytes;
        }
    }