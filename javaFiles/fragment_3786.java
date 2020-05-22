// Get the upload URL from the API
getUploadUrl = sApiServiceHandler.getUploadUrl(fileName, contentType);
MyApiResponse response = getUploadUrl.execute();
String uploadUrl = response.getString();

// Open connection to GCS
URL url = new URL(uploadUrl);
HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
httpConnection.setDoOutput(true);
httpConnection.setRequestMethod("PUT");
httpConnection.setRequestProperty("Content-Type", contentType);

// Write file data
OutputStreamWriter out = new OutputStreamWriter(httpConnection.getOutputStream());
out.write(fileData);
out.flush();

// Get response, check status code etc.
InputStreamReader in = new InputStreamReader(httpConnection.getInputStream());
// ...