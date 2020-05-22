public static String stringYak(String str) {
  char[] chars = (str != null) ? str.toCharArray()
      : new char[] {};
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < chars.length; i++) {
    if (chars[i] == 'y' && chars[i + 2] == 'k') { // if we have 'y' and two away is 'k'
                                                  // then it's unlucky...
      i += 2;
      continue; //skip the statement sb.append 
    }           //do not append any pattern like y1k or yak etc
    sb.append(chars[i]);
  }
  return sb.toString();
}

public static void main(String[] args) {
  System.out.println(stringYak("1yik2yak3yuk4")); // Remove the "unlucky" strings
                                                  // The result will be 1234.
}