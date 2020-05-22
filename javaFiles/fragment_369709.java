public void setVerticesAndDraw(Float value, GL10 gl, byte color) {
            FloatBuffer vertexbuffer;
            ByteBuffer indicesBuffer;
            ByteBuffer mColorBuffer;

            byte indices[] = {0, 1, 2, 0, 2, 3};

            float vetices[] = {//
                    -value, value, 0.0f,
                    value, value, 0.0f,
                    value, -value, 0.0f,
                    -value, -value, 0.0f
            };

            byte colors[] = //3
                    {color, color, 0, color,
                            0, color, color, color,
                            0, 0, 0, color,
                            color, 0, color, maxColor
                    };


            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vetices.length * 4);
            byteBuffer.order(ByteOrder.nativeOrder());
            vertexbuffer = byteBuffer.asFloatBuffer();
            vertexbuffer.put(vetices);
            vertexbuffer.position(0);

            indicesBuffer = ByteBuffer.allocateDirect(indices.length);
            indicesBuffer.put(indices);
            indicesBuffer.position(0);

            mColorBuffer = ByteBuffer.allocateDirect(colors.length);
            mColorBuffer.put(colors);
            mColorBuffer.position(0);


            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexbuffer);
            gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, mColorBuffer);

            gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, indicesBuffer);
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        }