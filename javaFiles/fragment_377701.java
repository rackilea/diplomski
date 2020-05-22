Locale locale = Locale.getDefault();
String lang = locale.getDisplayLanguage();

Class<?> c = myObject.getClass();
Field f = c.getDeclaredField("text_" + lang);

String value = (String) f.get(myObject);