// 1 short + 3 floats + 1 short, no paddings
int sizeOfVertex = 2 + 4 + 4 + 4 + 2; 

// Allocate data for 2 vertices
ByteBuffer data = ByteBuffer.allocateDirect(sizeOfVertex * 2);

// Set vertices[0].a and vertices[0].x and vertices[0].y
data.position(0).asShortBuffer().put(0, a0);
data.position(2).asFloatBuffer().put(0, x0);
data.position(2).asFloatBuffer().put(1, y0);

// Set vertices[1].a and vertices[1].x and vertices[1].y
data.position(sizeOfVertex+0).asShortBuffer().put(0, a1);
data.position(sizeOfVertex+2).asFloatBuffer().put(0, x1);
data.position(sizeOfVertex+2).asFloatBuffer().put(1, y1);

// Copy the Vertex data to the device
cudaMemcpy(deviceData, Pointer.to(data), cudaMemcpyHostToDevice);