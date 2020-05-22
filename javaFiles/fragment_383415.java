Undertow.builder()
       .setHandler(...)
       .setServerOption(UndertowOptions.URL_CHARSET, "UTF8")
       .addHttpListener(port, host)
       .build()
       .start();