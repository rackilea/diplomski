String str = "bevæge";

    byte[] b = str.getBytes();

    try {
        System.out.println(new String (b, "US-ASCII"));
        System.out.println(new String (b, "UTF8"));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }