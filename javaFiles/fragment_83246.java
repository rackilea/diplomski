} catch(IOException e1) {
    logger.log(Level.FINER, "ServerImpl.Exchange (1)", e1);
    if(e1 instanceof SSLException) {
        try {
            rawout = new Request.WriteStream(ServerImpl.this, chan);
            StringBuilder builder = new StringBuilder(512);
            int code = Code.HTTP_MOVED_PERM;
            builder.append("HTTP/1.1 ").append(code).append(Code.msg(code)).append("\r\n");
            builder.append("Location: https://www.example.com:"+ wrapper.getAddress().getPort() +"\r\n");
            builder.append("Content-Length: 0\r\n");
            String s = builder.toString();
            byte[] b = s.getBytes("ISO8859_1");
            rawout.write(b);
            rawout.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    closeConnection(connection);
} catch [...]