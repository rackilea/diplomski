ServerSocket svr = new ServerSocket(8900);
        System.out.println("waiting for request");
        Socket s = svr.accept();
        System.out.println("got a request");
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        int x;
        byte data[] = new byte[1024];

        x = in.read(data);

        String t = "HTTP/1.1 200 OK\r\n";
        byte[] bb = t.getBytes("UTF-8");
        out.write(bb);

        t = "Content-Length: 124\r\n";
        bb = t.getBytes("UTF-8");
        out.write(bb);
        t = "Content-Type: text/html\r\n\r\n";
        bb = t.getBytes("UTF-8");
        out.write(bb);

        String response = "<html><head><title>HTML content via java socket</title></head><body><h2>Hi! Every Body.</h2></body></html>";
        out.write(response.getBytes("UTF-8"));

        t = "Connection: Closed";
        bb = t.getBytes("UTF-8");
        out.write(bb);

        out.flush();

        s.close();
        svr.close();
        System.out.println("closing all");