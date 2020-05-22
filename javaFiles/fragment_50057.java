for (Pair<Classification, Interval> combo : listOfPairs) {
   if (combo.getInterval().contains(value)) {
     return combo.getClassification(); // yeeha found one
   }
 }
 return "nothing found" ... or throw some kind of exception