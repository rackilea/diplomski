/* will decode all parameters, header values, and content as ISO-8859-1 */
request.setCharacterEncoding(StandardCharsets.ISO_8859_1.name());
String actual = request.getParameter("body");
System.out.println("\"" + actual + "\"");

/* output on console of : " »= " */
/* that's a RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK followed by an EQUALS */