URL root = context.getResource( "/WEB-INF/classes/com/package/" );

// /default-host/WEB-INF/classes/
String rootPath = root.getPath();

// /WEB-INF/classes/
rootPath = rootPath.substring( rootPath.indexOf( "/WEB-INF" ), rootPath.length() );