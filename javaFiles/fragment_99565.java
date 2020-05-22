private void readLevelName() {

   String packageName = getPackageName();

   for (int i = 0 ; i <= 200 ; i++){
              String s = RRaw.substring(0,11)+i;
              map[i]= getResources().getIdentifier(s, "raw", packageName);
   }
}