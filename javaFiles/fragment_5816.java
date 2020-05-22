private static String getZipCommentFromBuffer (byte[] buffer, int len) {
  byte[] magicDirEnd = {0x50, 0x4b, 0x05, 0x06};
  int buffLen = Math.min(buffer.length, len);

  // Check the buffer from the end
  for (int i = buffLen - magicDirEnd.length - 22; i >= 0; i--) {
    boolean isMagicStart = true;

    for (int k = 0; k < magicDirEnd.length; k++) {
      if (buffer[i + k] != magicDirEnd[k]) {
        isMagicStart = false;
        break;
      }
    }

    if (isMagicStart) {
      // Magic Start found!
      int commentLen = buffer[i + 20] + buffer[i + 21] * 256;
      int realLen = buffLen - i - 22;
      System.out.println ("ZIP comment found at buffer position " 
        + (i + 22) + " with len = " + commentLen + ", good!");

      if (commentLen != realLen) {
        System.out.println ("WARNING! ZIP comment size mismatch: "
          + "directory says len is " + commentLen
          + ", but file ends after " + realLen + " bytes!");
      }

      String comment = new String (buffer, i + 22, Math.min(commentLen, realLen));
      return comment;
    }
  }

  System.out.println ("ERROR! ZIP comment NOT found!");
  return null;
}