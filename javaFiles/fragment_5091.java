DefaultHttpServerConnection conn = new DefaultHttpServerConnection();
conn.bind(serverSocket.accept(), new BasicHttpParams());
HttpRequest request = conn.receiveRequestHeader();
conn.receiveRequestEntity((HttpEntityEnclosingRequest)request);
HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
System.out.println(EntityUtils.toString(entity));