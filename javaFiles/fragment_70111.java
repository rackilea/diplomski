public void setupDatabase(Config config, Session session) 
{
        AugmentedImageDatabase aid = new AugmentedImageDatabase(session);
        Intent intent = getIntent ();
        String filepath = intent.getStringExtra ("filepath");
        Log.d ("AID", "Veriable:" + filepath);
        File directory = new File (filepath);
        File[] files = directory.listFiles ();
        Log.d ("AID", "Size: " + files.length);
        for (int i = 0; i < files.length; i++)
        {

            if (files[i].getName().startsWith("arimage"))
            {
                String filename = files[i].getName ();
                Log.d ("AID", "FileName:" + filename);
                Bitmap arcontentBitmap = loadAugmentedImage(files[i].getPath ());
                Log.d ("AID", "FilePath:" + files[i].getPath ());
                Log.d ("AID", "Files:" + files[i].getAbsolutePath ());
                String imagename = filename.substring(0, filename.length() - 4);
                Log.d ("AID", "NameImage:" + imagename);
                aid.addImage(imagename, arcontentBitmap);
            }
        }
        config.setAugmentedImageDatabase(aid);
}