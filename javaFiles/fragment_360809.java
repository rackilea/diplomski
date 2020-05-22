class Chunk {

private int vaoID;
private int vboID;
private int indexID;


public void createChunkVBO() {

    FloatBuffer vertices = BufferUtils.createFloatBuffer(16 * 256 * 16 * 3 * 8);
    FloatBuffer colors = BufferUtils.createFloatBuffer(16 * 256 * 16 * 4 * 8);
    FloatBuffer indices = BufferUtils.createFloatBuffer(16 * 256 * 16 * 24);

    // I am assuming that all of this is generated properly
    for (int x = 0; x < 16; x++) {
        for (int y = 0; y < 256; y++) {
            for (int z = 0; z < 16; z++) {
                System.out.println(x + ", " + y + ", " + z);
                vertices.put(x + World.BLOCK_SIZE);
                vertices.put(y);
                vertices.put(z + World.BLOCK_SIZE);

                vertices.put(x);
                vertices.put(y);
                vertices.put(z + World.BLOCK_SIZE);

                vertices.put(x);
                vertices.put(y);
                vertices.put(z);

                vertices.put(x + World.BLOCK_SIZE);
                vertices.put(y);
                vertices.put(z);

                vertices.put(x + World.BLOCK_SIZE);
                vertices.put(y + World.BLOCK_SIZE);
                vertices.put(z + World.BLOCK_SIZE);

                vertices.put(x);
                vertices.put(y + World.BLOCK_SIZE);
                vertices.put(z + World.BLOCK_SIZE);

                vertices.put(x);
                vertices.put(y + World.BLOCK_SIZE);
                vertices.put(z);

                vertices.put(x + World.BLOCK_SIZE);
                vertices.put(y + World.BLOCK_SIZE);
                vertices.put(z);


                colors.put(1f);
                colors.put(0f);
                colors.put(0f);
                colors.put(1f);

                colors.put(1f);
                colors.put(0f);
                colors.put(0f);
                colors.put(1f);

                colors.put(1f);
                colors.put(0f);
                colors.put(0f);
                colors.put(1f);

                colors.put(1f);
                colors.put(0f);
                colors.put(0f);
                colors.put(1f);

                colors.put(1f);
                colors.put(0f);
                colors.put(0f);
                colors.put(1f);

                colors.put(1f);
                colors.put(0f);
                colors.put(0f);
                colors.put(1f);

                colors.put(1f);
                colors.put(0f);
                colors.put(0f);
                colors.put(1f);

                colors.put(1f);
                colors.put(0f);
                colors.put(0f);
                colors.put(1f);


                indices.put(0 + x * y * z);
                indices.put(1 + x * y * z);
                indices.put(2 + x * y * z);
                indices.put(3 + x * y * z);


                indices.put(4 + x * y * z);
                indices.put(5 + x * y * z);
                indices.put(2 + x * y * z);
                indices.put(3 + x * y * z);


                indices.put(1 + x * y * z);
                indices.put(3 + x * y * z);
                indices.put(7 + x * y * z);
                indices.put(5 + x * y * z);


                indices.put(0 + x * y * z);
                indices.put(3 + x * y * z);
                indices.put(4 + x * y * z);
                indices.put(7 + x * y * z);


                indices.put(0 + x * y * z);
                indices.put(1 + x * y * z);
                indices.put(6 + x * y * z);
                indices.put(7 + x * y * z);


                indices.put(4 + x * y * z);
                indices.put(5 + x * y * z);
                indices.put(6 + x * y * z);
                indices.put(7 + x * y * z);

            }
        }
    }

    vertices.flip();
    colors.flip();
    indices.flip();


    glGenVertexArrays(vaoID); // Create an id for the VAO
    glBindVertexArray(vaoID); // Bind the VAO so it remembers all the Attributes (none right now)

    glGenBuffers(vboID); // Create an id for the VBO
    glBindBuffer(GL_ARRAY_BUFFER, vboID); // Bind the VBO so we can put data into it

    glBufferData(GL_ARRAY_BUFFER, 16 * 256 * 16 * 8 * 7 * Float.SIZE, GL_STATIC_DRAW); // We make an empty buffer with a specific size in bytes
                                                                    // 8 * 7 * sizeof(float)
                                                                    // 8 = number of vertices, 7 = xyzrgba
    // I have not used subdata like this before so I will assume this is correct.
    glBufferSubData(GL_ARRAY_BUFFER, 0, vertices); // Put the vertices at the beginning of the buffer
    glBufferSubData(GL_ARRAY_BUFFER, 16 * 256 * 16 * 8 * 3 * Float.SIZE, colors); // Put the colors after the vertices


    glGenBuffers(indexID); // Create an id for the Index Buffer
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexID); // Bind the Index Buffer so we can put data into it
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW); // Store the indices inside the currently bound Index Buffer

}

public void drawChunk() {

    glEnableClientState(GL_VERTEX_ARRAY); // Enable the Vertex Array
    glEnableClientState(GL_COLOR_ARRAY); // Enable the Color Array

    glVertexPointer(3, GL_FLOAT, 0, 0);
    glColorPointer(4, GL_FLOAT, 0, 16 * 256 * 16 * 8 * 3 * Float.SIZE); // Position of the colors in the currently bound buffer

    glDrawElements(GL_QUADS, 8 * 16 * 256 * 24, GL_UNSIGNED_INT, 0); // Draws the elements from the Index Buffer
}
}