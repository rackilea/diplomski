int silenceSamples = (audioInfo.rate * padding) * 2;
            float[] mixedBuffer = new float[minBufferSize + silenceSamples]
    for (int i = 0; i < minBufferSize + silenceSamples; i++){

    if (i < silenceSamples )
    {       
        mixedBuffer[i] = (float) stereoWavBuffer[i];  
    }
    else if(i < minBufferSize)
    {
        mixedBuffer[i] = (float) (stereoWavBuffer[i] + mp3Buffer[i-silenceSamples]);
    }
    else 
    {
        mixedBuffer[i] = (float) (mp3Buffer[i-silenceSamples]);
    }