HttpResponse response = client.execute(request);
HttpEntity entity = response.getEntity();

//http://stackoverflow.com/questions/1264709/convert-inputstream-to-byte-in-java
byte[] content = streamToByteArray(entity.getContent());

String ct = t.parseToString(new ByteArrayInputStream(content));
System.out.println(ct);

Metadata md = new Metadata();
Reader r = t.parse(new ByteArrayInputStream(content), md);
System.out.println(md);