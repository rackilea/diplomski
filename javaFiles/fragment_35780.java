Bitmap temp = null;
        try {
            if (temp_url.length() > 5) {                    
                  temp = BitmapFactory.decodeStream((InputStream)new URL(temp_url).getContent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        hotel_pic.setImageBitmap(temp);