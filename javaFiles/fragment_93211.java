public static int getIntValForString(String strVal) {
   for (MembershipTypes e : MembershipTypes.values()) {
      if (e.getStrVal().equals(strVal)) {
         return e.getIntVal();
      }
   }
   throw new IllegalArgumentException("No such enum for string val:" + strVal);
}