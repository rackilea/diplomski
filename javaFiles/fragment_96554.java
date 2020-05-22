for (int i = 0; i < phrase.length(); i++) {
     if (!isDelim(phrase.charAt(i))) {
        isTrue++;
     } else {
        isFalse++;
     }
  }