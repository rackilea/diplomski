String msg = o.getTweet();
    if (msg.indexOf("&amp;") != -1) {
        msg = msg.replaceAll("&amp;", "&");// vervangt &amp; door &
    }
    if (msg.indexOf("&quot;") != -1) {
        msg = msg.replaceAll("&quot;", "aa"); //vervangt &quot; door "
    }