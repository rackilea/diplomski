// remove illegal unicode characters
    String xml10pattern = "[^"
            + "\u0009\r\n"
            + "\u0020-\uD7FF"
            + "\uE000-\uFFFD"
            + "\ud800\udc00-\udbff\udfff"
            + "]";

    stringValue = stringValue.replaceAll(xml10pattern, " ");