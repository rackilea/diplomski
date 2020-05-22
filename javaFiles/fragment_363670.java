// in hz, number of samples in one second
sampleRate = 44100

// this is the time BETWEEN Samples
samplePeriod = 1.0 / sampleRate

// 2ms
duration = 0.002;
durationInSamples = Math.ceil(duration * sampleRate);

time = 0;
for(int i = 0; i < durationInSamples; i++)
{
  // sample a sine wave at 440 hertz at each time tick
  // substitute a function that generates a sawtooth as a function of time / freq
  // rawOutput[i] = function_of_time(other_relevant_info, time);
  rawOutput[i] = Math.sin(2 * Math.PI * 440 * time);
  time += samplePeriod;
}

// now you can playback the rawOutput
// streaming this may be trickier