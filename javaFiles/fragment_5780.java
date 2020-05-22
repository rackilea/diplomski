Locale filipinoLocale = new Locale("fil");
Resources filipinoResource = getLocalizedResources(context, filipinoLocale);

Locale russianLocale = new Locale("ru");
Resources russianResource = getLocalizedResources(context, russianLocale);

Locale chineseLocale = new Locale("zh");
Resources chineseResource = getLocalizedResources(context, chineseLocale);

String filipinoString = filipinoResource.getString(R.string.mystring);
String russianString = russianResource.getString(R.string.mystring);
String chineseString = chineseResource.getString(R.string.mystring);