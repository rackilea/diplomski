float[] vertData = Update.object.get(i).getVertices();
float[] colorData = Update.object.get(i).getColors();

for(int j = 0; j < vertData.length; j += 3) {
   drawData.put(vertData, j, 3)
   drawData.put(colorData, j, 3)
}