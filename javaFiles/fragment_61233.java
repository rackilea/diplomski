for (int i = 0; i < vertexData.length / vertexDataSize; i++){

      float x = Float.parseFloat(allindices2  [Integer.parseInt(allindices2[i * source.size() + 0]) * 3 + 0]);
      float y = Float.parseFloat(allpositions2[Integer.parseInt(allindices2[i * source.size() + 0]) * 3 + 1]);
      float z = Float.parseFloat(allpositions2[Integer.parseInt(allindices2[i * source.size() + 0]) * 3 + 2]);

      vertices.add(new Vector3f(x,y,z));
}