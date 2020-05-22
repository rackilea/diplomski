bindFactory(EncCipherFactory.class)
        .proxy(true)
        .proxyForSameScope(false)
        .to(Cipher.class)
        .named("ENC_CIPHER")
        .in(RequestScoped.class);