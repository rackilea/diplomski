Map<Date,DatedValue> result = new LinkedHashMap<Date,DatedValue>();
for(DatedValue dv : datedValues) {
  DatedValue newDV = result.get(dv.getDate());
  if (newDV == null) {
    newDV = dv;
  } else {
    newDV = new DatedValue(dv.getDate(), dv.getValue().add(newDV.getValue()));
  }
  result.put(dv.getDate(), newDV);
}
List<DatedValue> sums = new ArrayList<DatedValue>(result.values());