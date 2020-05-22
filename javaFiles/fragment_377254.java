String data = getData();
this.points = new ArrayList<Integer>(); //if this is a field you should use points.clear() instead.

for (int i=0; i<data.length(); i++) {
  this.points.add(Characacter.getNumericValue(data.charAt(i)));
}