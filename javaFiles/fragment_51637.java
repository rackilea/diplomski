int samples = 2 << 19;
byte audioBuffer[] = new byte[samples * channels * sampleSizeInBytes];

for ( int i = 0, j = 0; i < samples; ++i )
{
    int wave = (int)(32767.0 * Math.sin(2.0 * Math.PI * frequency * i / sampleRate));
    byte msb = (byte)(wave >>> 8);
    byte lsb = (byte) wave;

    for (int c = 0; c < channels; ++c) {
        audioBuffer[j++] = msb;
        if (sampleSizeInBytes > 1) {
            audioBuffer[j++] = lsb;
        }
    }
 }