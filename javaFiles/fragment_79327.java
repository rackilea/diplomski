private final static int MY_PHONE_NUMBER_MINIMUM_DIGITS = 6;

Linkify.addLinks(main, Patterns.PHONE, "tel:", new Linkify.MatchFilter() {
     public final boolean acceptMatch(CharSequence s, int start, int end) {
       int digitCount = 0;

       for (int i = start; i < end; i++) {
         if (Character.isDigit(s.charAt(i))) {
           digitCount++;
           if (digitCount >= MY_PHONE_NUMBER_MINIMUM_DIGITS ) {
             return true;
         }
       }
     }
      return false;
    }
  }, Linkify.sPhoneNumberTransformFilter);