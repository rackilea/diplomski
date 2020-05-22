public String decrypt(String key, String cipher) {
       String cipherModified = removeSalt(key, cipher);
       List<String> keyPairs = splitKeyToPairs(key.substring(1, key.length()));
       String message = "";
       for(int position = 0; position < keyPairs.size();++position) {
         String keyTmp = keyPairs.get(position);
         String cipherLetter = cipherModified.substring(position, position + 1);
         message += "0".equals(keyTmp.substring(0, 1)) ? shiftBackwards(cipherLetter, keyTmp.substring(1, 2)) : shiftForward(cipherLetter, keyTmp.substring(1, 2));
       }

       return message;  
    }

    public List<String> splitKeyToPairs(String key) {
      List<String> result = new ArrayList<String>();
      for(int i = 0; i < key.length(); i += 2) {
        //i += 2 because we jump 2 characters per iteration.
        result.add(key.substring(i, i+2));
      }

      return result;
    }