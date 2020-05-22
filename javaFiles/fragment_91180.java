try {
   FileInputStream fis = mActivity.openFileInput(fileName);
   ObjectInputStream is = new ObjectInputStream(fis);
   while(true) {
      try {
         stateDetails = (StateDetails) is.readObject();
      }
      catch(EOFException ex) {
          is.close();
          break;     
      }
   }
}
catch (Exception e) {
   MyApplication.SWERR(e);
}