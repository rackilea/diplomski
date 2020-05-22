final byte[] content = xml.getBytes("UTF-8");
response.setContentLength(content.length);
response.setContentType("text/xml"); // or "text/xml; charset=UTF-8"
response.setCharacterEncoding("UTF-8");

final OutputStream out = response.getOutputStream();
out.write(content);