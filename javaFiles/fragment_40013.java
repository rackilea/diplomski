/*
* if the requested file does not exist, throw an exception formerly the
* Error page from the server was returned if the requested file was
* text/html this has changed to return FileNotFoundException for all
* file types
*/
if (responseCode >= HTTP_BAD_REQUEST) {
   throw new FileNotFoundException(url.toString());
}