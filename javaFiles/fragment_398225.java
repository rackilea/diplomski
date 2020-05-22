protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK)
        {
            try
            {
                AssetFileDescriptor videoAsset = getContentResolver().openAssetFileDescriptor(data.getData(), "r");
                FileInputStream fis = videoAsset.createInputStream();
                File root=new File(Environment.getExternalStorageDirectory(),"/RecordVideo/");  //you can replace RecordVideo by the specific folder where you want to save the video
                if (!root.exists()) {
                    System.out.println("No directory");
                    root.mkdirs();
                }

                File file;
                file=new File(root,"android_"+System.currentTimeMillis()+".mp4" );

                FileOutputStream fos = new FileOutputStream(file);

                byte[] buf = new byte[1024];
                int len;
                while ((len = fis.read(buf)) > 0) {
                    fos.write(buf, 0, len);
                }
                fis.close();
                fos.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }