try {
   File root = Environment.getExternalStorageDirectory();
   File myFile = new File(root +"/textfile.txt");
   myFile.createNewFile();

   FileOutputStream fOut = new FileOutputStream(myFile);
   OutputStreamWriter myOutWriter = 
         new OutputStreamWriter(fOut);
   myOutWriter.append("String entered in file");

   myOutWriter.close();
   fOut.close();
} catch (Exception e) {
   Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

}