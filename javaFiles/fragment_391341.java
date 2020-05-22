try{
 int registerState = 0;
 registerState = Integer.parseInt(DevTools.getPreferences_String(getApplication(), "appPrefs", "reg", "0"));
  }
catch(Exception e){
   }