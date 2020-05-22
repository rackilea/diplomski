String eol = "\r\n";
Charset charset = Charset.forName("ASCII");
byte[] eolBytes = eol.getBytes(charset);
out.write(StatusLine.getBytes(charset));
out.write(eolBytes);
out.write( ServerLine.getBytes(charset));
out.write(eolBytes);
out.write(ContentTypeLine.getBytes(charset));
out.write(eolBytes);
out.write( ContentLengthLine.getBytes(charset));
out.write(eolBytes);
// End of the header
out.write(eolBytes);
// Here the body begin