byte[] buffer = new byte[16384];

while ((byteread = is.read(buffer, 0, buffer.length)) != -1) {
  out.write(buffer, 0, byteread);
}

out.flush();