boolean mExternalStorageAvailable = false;
    boolean mExternalStorageWriteable = false;

    String state = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED.equals(state)) {  
        // We can read and write the media    
        mExternalStorageAvailable = mExternalStorageWriteable = true;
    } 
    else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) { 
        // We can only read the media   
        mExternalStorageAvailable = true;    
        mExternalStorageWriteable = false;
    } else {   
        // Something else is wrong. It may be one of many other states, but all we need   
        //  to know is we can neither read nor write  
        mExternalStorageAvailable = mExternalStorageWriteable = false;
    }   

    if ( mExternalStorageAvailable == true && mExternalStorageAvailable == true){

        File mFile = new File(Environment.getExternalStorageDirectory(), "/DCIM/filename.txt");
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(mFile, true)); 
            buf.write("test txt");
            buf.close();
            Toast.makeText(getBaseContext(), "path = "+mFile, Toast.LENGTH_LONG).show();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "File not FOund", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "IOException", Toast.LENGTH_LONG).show();
        }
    }