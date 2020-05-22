if ((checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)   == PackageManager.PERMISSION_GRANTED)&& Build.VERSION.SDK_INT >= 23 ) {
                Log.v(TAG,"Permission is granted");
                return true;}
              else{
              ActivityCompat.requestPermissions(this, new String[]Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
                  }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
             String state = Environment.getExternalStorageState();
            if (!Environment.MEDIA_MOUNTED.equals(state)) {
                Toast.makeText(getApplicationContext(), "Access denied", Toast.LENGTH_LONG).show();
            }
            String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/data";
            File dir = new File(path);
            dir.mkdirs();
             File file = new File(path + "/savedFile.txt");
            String saveText = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

                 try {
                       fos = new FileOutputStream(file);
                       OutputStreamWriter ow =  new OutputStreamWriter(fos);
                       ow.write(saveText.getBytes());
                       ow.append(saveText.getText());
                       ow.close();
                       fos.close();
                       Toast.makeText(getBaseContext(),
                       "Done writing SD 'mysdfile.txt'",Toast.LENGTH_SHORT).show();
                     }} catch (Exception e) {
                            Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                                           }

        }
    }