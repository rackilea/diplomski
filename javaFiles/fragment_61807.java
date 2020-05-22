String link = "image0=images/articles/4_APRIL_BLACK_copy.jpg";
    String[] parts = link.split("=");

    String first = parts[0];
    Log.v("FIRST", first);

    String second = parts[1];
    Log.v("SECOND", second);