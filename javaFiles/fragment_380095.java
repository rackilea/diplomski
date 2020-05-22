ShortBuffer buf=ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN)
               .asShortBuffer();
int numOfSamples = buf.remaining();
double[] amplitudes = new double[numOfSamples];
for (int i = 0; i < numOfSamples; i++) {
    amplitudes[i] = buf.get() * (1.0/32768.0);
}
return amplitudes;