property.put("xyz", "serverpath");
property.put("*abc", "serverIPAddress");
ByteArrayOutputStream out = new ByteArrayOutputStream();
property.storeToXML(out, null, "UTF-8");
String str = out.toString("UTF-8").replaceAll("<!DOCTYPE[^>]*>\n", "");
byte[] bytes = str.getBytes("UTF-8");
OutputStream outs = response.getOutputStream();
outs.write(bytes, 0, bytes.length);
outs.close();