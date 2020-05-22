// Replace backslashes first, as it is used for escaping
myVar = myVar.replaceAll(Pattern.quote("\\"), "\\\\\\\\");

// Then replace all the other special characters
myVar = myVar.replaceAll(Pattern.quote("/"), "\\\\/");
myVar = myVar.replaceAll(Pattern.quote("&"), "\\\\&");
myVar = myVar.replaceAll(Pattern.quote("$"), "\\\\\\$");
myVar = myVar.replaceAll(Pattern.quote("'"), "'\"'\"'");