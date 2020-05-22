ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObejctOutputStream oos = new ObejctOutputStream(baos);
oos.write(...);

byte[] data = baos.toByteArray();

response.setHeader("Content-Length", "" + data.length);
response.getOutputStream().write(data);