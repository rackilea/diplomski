Vector3f currentVertex = vertices.get(Integer.parseInt(vertexData[0]) - 1);
verticesArray[currentVertexPointer * 3] = currentVertex.x;
verticesArray[currentVertexPointer * 3 + 1] = currentVertex.y;
verticesArray[currentVertexPointer * 3 + 2] = currentVertex.z;
Vector2f currentTex = textures.get(Integer.parseInt(vertexData[1]) - 1);
textureArray[currentVertexPointer * 2] = currentTex.x;
textureArray[currentVertexPointer * 2 + 1] = 1 - currentTex.y;