for (int i = 0, n = buffer.length; i < n; i++)
{
    buffer[i] *= 32767;
    audioBytes[i*2] = (byte) buffer[i];
    audioBytes[i*2 + 1] = (byte)((int)buffer[i] >> 8 );
}
return audioBytes;