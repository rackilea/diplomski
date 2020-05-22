final FloatBuffer[] floatBuffers = new FloatBuffer[] {...};
final ByteBuffer byteBuffer = ByteBuffer.allocate(sumOfFloatBufferCapacities) * 4);
final FloatBuffer floatBufView = byteBuffer.asFloatBuffer();
for (final FloatBuffer fBuf : floatBuffers) {
    floatBufView.put(fBuf);
}
byte[] data = byteBuffer.array();