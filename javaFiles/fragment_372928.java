int contentLength = req.getContentLength();

// Prepare Reponse Headers
response.setContentType(req.getContentType());
response.setHeader("Content-Disposition", "attachment; filename=download.pdf");

// Stream to Response
InputStream in = req.getInputStream();
OutputStream output = response.getOutputStream();
int count;
byte[] buffer = new byte[8192];
while ((count = in.read(buffer)) > 0) output.write(buffer, 0, count);