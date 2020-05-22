public static final MatchFilter sPhoneNumberMatchFilter = new MatchFilter() {
    public final boolean acceptMatch(CharSequence s, int start, int end) {
      int digitCount = 0;

      for (int i = start; i < end; i++) {
        if (Character.isDigit(s.charAt(i))) {
          digitCount++;
          if (digitCount >= PHONE_NUMBER_MINIMUM_DIGITS/*=5*/) {
            return true;
        }
      }
    }
    return false;
 }