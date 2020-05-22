// original line 149
//return new File(file).getCanonicalPath().substring(prefix.length() + 1);

String result = new File(file).getCanonicalPath().substring(prefix.length() + 1);
if (File.separatorChar != '/') {
  result = result.replace(File.separatorChar, '/');
}
return result;