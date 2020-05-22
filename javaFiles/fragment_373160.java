final int length = s.length();
for (int offset = 0; offset < length; ) {
   final int codepoint = s.codePointAt(offset);

   // do something with the codepoint

   offset += Character.charCount(codepoint);
}