public long encodeHobbies(List<String> hobbies, BitPositionDictionary dict) {
      long encoded = 0;
      for(String hobby : hobbies) {
          int pos = dict.getPosition(hobby); // if not found, allocates new
          encoded &= (1 << pos)
      }
      return encoded;
 }