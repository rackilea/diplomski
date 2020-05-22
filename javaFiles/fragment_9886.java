public boolean setLabel(String labelIn) {
   if (labelIn == null) {
      return false;
   }
   labelIn = labelIn.trim();
   label = labelIn;
   return true;
}