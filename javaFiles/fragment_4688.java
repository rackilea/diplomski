InputStreamReader reader = null;
try {
   all the stuff that might fail (IOException etc...)
}
finally {
  if (reader != null)
    try {
       reader.close();
    }
    catch (IOExcetpion ioe) {
       ; // this is one of the very few cases it's best to ignore the exception
    }
}