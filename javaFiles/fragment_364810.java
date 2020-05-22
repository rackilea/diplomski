String path = application.getRealPath(request.getServletPath());
System.out.println("path: " + path);

path = path.substring(0, path.lastIndexOf(java.io.File.separator));
System.out.println("path: " + path);

String dictionaryPath = path + java.io.File.separator + "dictionaries/english.txt";
System.out.println("dictionaryPath: " + dictionaryPath);

String userdict = path + java.io.File.separator + "spellchecker/dictionaries/user/user-dictionary.txt";
System.out.println("userdict: " + userdict);