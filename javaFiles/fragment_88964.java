for (Map.Entry<Integer, OutcomeProcessor> entry : ourMap.entrySet()) {
   int mask = entry.getKey();
   if ((mask & inK) == mask) {
      // invoke processor
      entry.getValue().method(<list of parameters>);
   }
}