int statusCode = response.getStatusLine().getStatusCode();
Logger.d("Response returned status code " + statusCode);

if (HttpStatus.SC_OK == statusCode) {
    // TODO: handle 200 OK
} else if (HttpStatus.SC_NOT_FOUND == statusCode) { 
    // TODO: handle 404 Not Found
} else { 
    // TODO: handle other codes here
}