double[] flat = bundle.getDoubleArray("Lat");
String[] flatAsStrings = new String[flat.length];

for (int i = 0; i < flat.length; i++) {
    flatAsStrings[i] = String.valueOf(flat[i]);
}