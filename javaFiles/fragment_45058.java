String generateFromRegex(string regex, Random r) {
   String charsRegex = regex.replaceAll("[{].*", ""); // strip off repetition count
   StringBuilder valid = new StringBuilder();
   final Charset charset = Charset.forName("US-ASCII"); // assume us-ascii
   for (int i = 0; i < 255; i++) {
     ByteBuffer bb = ByteBuffer.allocate(4);
     bb.putInt(i);
     String charString = new String(bb.array(), charset).trim();
     if (charString.length() == 1 && charString.matches(charsRegex)) {
        valid.append(charString);
     }
   }
   int length = Integer.parseInt(
                  regex.replaceAll(".*[{]", "").replaceAll("}", ""));
   return generateID(valid, length, r);
}