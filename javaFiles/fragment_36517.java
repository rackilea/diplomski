Couple createCouple() {
   Dancer a = findUnpartnered(aList);
   Dancer b = findUnpartnered(bList);
   if (a == null || b == null) {
      return null;
   } else {
      a.setPartnered(true);
      b.setPartnered(true);
      return new Couple(a, b);
   }
}