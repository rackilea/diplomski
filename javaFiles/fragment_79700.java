ByteBuffer buf = ByteBuffer.allocate(1000);
buf.put(Base64.decodeBase64("PzlbwtWRpmFWjG0JRIRn7A=="));
buf.put("2012-06-09T18:41:03.640Z".getBytes("UTF-8"));
buf.put("password".getBytes("UTF-8"));
byte[] toHash = new byte[buf.position()];
buf.rewind();
buf.get(toHash);
byte[] hash = DigestUtils.sha(toHash);
System.out.println("Generated password digest: " + Base64.encodeBase64String(hash));