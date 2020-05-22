try {
    value = URLDecoder.decode(keyVal[1], "UTF-8");
} catch (UnsupportedEncodingException e) {
    throw new AssertionError("UTF-8 is unknown");
    // or 'throw new AssertionError("Impossible things are happening today. " +
    //                              "Consider buying a lottery ticket!!");'
}