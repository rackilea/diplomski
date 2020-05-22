private class AWSImageFetcher extends AsyncTask<String, Void, Bitmap> 
{
    boolean authenticated;

    @Override
    protected void onPreExecute() 
    {
        super.onPreExecute();
        authenticated=authenticate();
    }

    @Override
    protected Bitmap doInBackground(String... urls) 
    {
        Bitmap b=null;
        if(authenticated)
        {
                URL imageUrl = new URL(urls[0]);
            HttpURLConnection conn = (HttpURLConnection) imageUrl
                    .openConnection();
            conn.setConnectTimeout(TIME_OUT_IN_MILLI_SECONDS);
            conn.setReadTimeout(TIME_OUT_IN_MILLI_SECONDS);
            conn.setInstanceFollowRedirects(true);
            InputStream is = conn.getInputStream();
            OutputStream os = new FileOutputStream(f);
            Utils.CopyStream(is, os);
            os.close();
            b = decodeFile(f);
        }
        return b;
    }

    @Override
    protected void onPostExecute(Bitmap result) 
    {
        super.onPostExecute(result);
        if(result!=null)
        {               
            //use bitmap image in result    
        }
       else
       {   
          //Image is not available
       }    

    }

 }


//decodes image and scales it to reduce memory consumption
private Bitmap decodeFile(File f) {
    try {
        // decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        FileInputStream stream1 = new FileInputStream(f);
        BitmapFactory.decodeStream(stream1, null, o);
        stream1.close();

        // Find the correct scale value. It should be the power of 2.
        final int REQUIRED_SIZE = 70;
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE
                    || height_tmp / 2 < REQUIRED_SIZE)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        FileInputStream stream2 = new FileInputStream(f);
        Bitmap bitmap = BitmapFactory.decodeStream(stream2, null, o2);
        stream2.close();
        return bitmap;
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}