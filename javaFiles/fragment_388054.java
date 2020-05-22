Field[] fields = Class.forName(getPackageName()+".R$color").getDeclaredFields();
for(Field field : fields) {
    String colorName = field.getName();
    int colorId = field.getInt(null);
    int color = getResources().getColor(colorId);
    Log.i("test", colorName + " => " + colorId + " => " + color);
}