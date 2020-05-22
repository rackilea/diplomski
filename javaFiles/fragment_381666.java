byte [] makeFingerprint(String s) {
  byte[] fingerprint = new byte[26];
  for (char c : letter_2) {
    fingerprint[c - 'a']++;
  }

  return fingerprint;
}

/** determine if sub is a subset of super */
boolean isSubset(byte[] sub, byte[] super) {
  for (int i=0; i < sub.length; i++) {
    if (sub[i] > super[i]) 
      return false;
  }
  return true;
}

void findMatch(String jumbledWord) {

  byte[] fingerprint = makeFingerprint(jumbledWord);

  for (byte[] candidate : fingerprintList) {   
        if (isSubset(fingerprint, candidate)) {
            System.out.println("Your word is: " + ...);
            break;                
        }
    }
}