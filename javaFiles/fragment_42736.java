DataOutptuStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

out.writeShort(length);
out.write(messageId);
out.write(msgtype);
out.write((var1+"\0\0\0\0").substring(0, 4).getBytes("ISO-8859-1"));
out.write(var2.getBytes("ISO-8859-1"));
out.write(var2);

out.flush(); // optionally.