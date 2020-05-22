Resources res = getResources();
String pkg = getPackageName();
for (int i=0; i<textLength; i++) {
    int resId = res.getIdentifier("intro_text_" + i, "string", pkg);
    introTextToShow[i] = res.getString(resId);
}