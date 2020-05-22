private void putValue(String key, Integer value) {
      int firstLetterInt = (int) key.charAt(0);
      if (firstLetterInt % 2 == 0) {
          hm1.put(key, value);
      }
      else {
          hm2.put(key, value);
      }
 }