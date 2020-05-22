for (int i = 0; i < vertexData.length / vertexDataSize; i++){
      int index = Integer.parseInt(allindices2[i * source.size()]);
      float x = Float.parseFloat(allpositions2[index * 3 + 0]);
      float y = Float.parseFloat(allpositions2[index * 3 + 1]);
      float z = Float.parseFloat(allpositions2[index * 3 + 2]);
      vertices.add(new Vector3f(x,y,z));
}