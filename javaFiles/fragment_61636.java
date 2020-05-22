Map<String, Object> main = new LinkedHashMap<>();
    Map<String, Object> sub = new LinkedHashMap<>();
    sub.put("tipoIdentificacion", "02");
    sub.put("numeroIdentificacion", "402260222");

    main.put("clave", "50601011600310112345600100010100000000011999999999");
    main.put("fecha", "2016-01-01T00:00:00-0600");
    main.put("emisor" , sub);
    main.put("comprobanteXml", "test");