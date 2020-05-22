stream.write(("Content-type: image/jpeg\r\n" +
                      "Content-Length: " + buffer.size() + "\r\n" +
                      "X-Timestamp:" + timestamp + "\r\n" +
                      "\r\n").getBytes());

buffer.writeTo(stream);
stream.write(("\r\n--" + boundary + "\r\n").getBytes());