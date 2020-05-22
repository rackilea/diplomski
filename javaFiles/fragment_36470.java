byte[] buffer = new byte[2048];
float[] fBuffer = new float[buffer.length >> 2];

ByteBuffer bb = ByteBuffer.wrap(buffer);
FloatBuffer fb = bb.asFloatBuffer();
fb.get(fBuffer, 0, fBuffer.length);