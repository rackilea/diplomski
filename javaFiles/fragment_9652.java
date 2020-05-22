if (photo != null) {
                photo.getDataInBackground(new GetDataCallback() {

                    @Override
                    public void done(byte[] data, ParseException e) {
                        // TODO Auto-generated method stub
                        if (data != null && e == null) {
                            Bitmap bitmap = BitmapFactory
                                    .decodeByteArray(data, 0,
                                            data.length);
                            image.setImageBitmap(bitmap);

                        } else {
                            //ParseException e
                        }
                    }
                });
            } else {
                //picture_not_available
            }