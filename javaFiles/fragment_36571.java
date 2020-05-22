public int getID(String drawableName){
   Resources resources = context.getResources();
   final int resourceId = resources.getIdentifier(drawableName, "drawable", 
   context.getPackageName());
   return resources.getDrawable(resourceId);
}