ImageReadParam param = reader.getDefaultReadParam();
param.setDestination(img);

for (int i = 0; i++; i < n) {
    param.setDestinationOffset(new Point(w * i, 0);
    reader.read(i, param);
}