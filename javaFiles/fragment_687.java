public void recieve(float[] coords) {
   this.list.add(convertToFloat(coords));
}

public Float[] convertToFloat(float[] coords) {
  Float[] converted = new Float[coords.length];
  for (int i = 0; i < coords.length; i++) {
     converted[i] = Float.valueOf(coords[i]));
  }
  return converted;
}