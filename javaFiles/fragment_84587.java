// Pattern to detect replaced custom text
Pattern profileLink     = Pattern.compile("[@]+[A-Za-z0-9-_]+\\b");

// Schema
String Link             = "content://"+Context.getString(R.string.profile_authority)+"/";

// Make it linkify ;)
Linkify.addLinks(textView, profileLink, Link);