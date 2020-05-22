final String UNDERLINE_ON = "\u001B\u002D\u0001";
final String UNDERLINE_OFF = "\u001B\u002D\u0000";
final String CRLF = "\r\n";

out.write(UNDERLINE_ON + "column 1 | column 2 | column 3" + UNDERLINE_OFF + CRLF);
out.write("value 11 | value 12 | value 13" + CRLF);
out.write("value 21 | value 22 | value 23" + CRLF);
out.write("value 31 | value 32 | value 33" + CRLF);