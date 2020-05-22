int contentLength = req.getContentLength();
byte ba[] = new byte[contentLength];
req.getInputStream().read(ba);
ByteArrayInputStream in = new ByteArrayInputStream(ba);

// Prepare Reponse Headers
response.setContentType(req.getContentType());
response.setContentLength(req.getContentLength());
response.setHeader("Content-Disposition", "attachment; filename=download.pdf");

// Stream to Response
OutputStream output = response.getOutputStream();
//OutputStream output = new FileOutputStream("c:\\temp\\op.pdf");
int count;
byte[] buffer = new byte[8192];
while ((count = in.read(buffer)) > 0) output.write(buffer, 0, count);