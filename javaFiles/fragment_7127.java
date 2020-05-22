double currentFrequency = getFrequency();
double smoothing  = 10;   // calculate based on your sample rate and desired time delta for the change
while (playing)
{
    double newFrequency = getFrequency();
    for (int i = 0; i < buffSize; i++)
    {
        // because you are filling the buffer, deltaTime will be a constant: the time between samples
        currentFrequency += deltaTime * ( newFrequency - currentFrequency ) / smoothing;
        samples[i] = (short) (amp * Math.sin(phase));
        phase += twopi * currentFrequency / sampleRate;
    }
    audioTrack.write(samples, 0, buffSize);
}