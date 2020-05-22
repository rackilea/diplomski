byte[] buf = new byte[200];
...
DefaultFullHttpRequest req = new DefaultFullHttpRequest(httpVersion, HttpMethod.POST, uri);
DefaultHttpDataFactory factory = new DefaultHttpDataFactory();
HttpPostRequestEncoder enc = new HttpPostRequestEncoder(factory, req, false, CharsetUtil.UTF_8, HttpPostRequestEncoder.EncoderMode.RFC1738);
Attribute attr = factory.createAttribute(req, "someBinaryVar");
attr.setContent(io.netty.buffer.Unpooled.wrappedBuffer(buf));
enc.addBodyHttpData(attr);
...
enc.finalizeRequest();