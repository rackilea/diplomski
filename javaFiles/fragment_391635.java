HttpProcessor httpProcessor = HttpProcessorBuilder.create()
            //.addFirst(new RequestTrace())
            .add(new ResponseDate())
            //.add(new ResponseServer("MyServer-HTTP/1.1"))
            .add(new ResponseContent())
            .add(new ResponseConnControl())
            .addLast(new ResposeKeepAliveHeaderMod())
            .build();