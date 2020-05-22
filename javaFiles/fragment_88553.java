public double getPitchInSampleRange(AudioSamples as, int start, int end) throws Exception {
    //If your sound is musical note/voice you need to limit the results because it wouldn't be above 4500Hz or bellow 20Hz
    int nLowPeriodInSamples = (int) as.getSamplingRate() / 4500;
    int nHiPeriodInSamples = (int) as.getSamplingRate() / 20;

    //I get my sample values from my AudioSamples class. You can get them from wherever you want
    double[] samples = Arrays.copyOfRange((as.getSamplesChannelSegregated()[0]), start, end);
    if(samples.length < nHiPeriodInSamples) throw new Exception("Not enough samples");

    //Since we're looking the periodicity in samples, in our case it won't be more than the difference in sample numbers
    double[] results = new double[nHiPeriodInSamples - nLowPeriodInSamples];

    //Now you iterate the time lag
    for(int period = nLowPeriodInSamples; period < nHiPeriodInSamples; period++) {
        double sum = 0;
        //Autocorrelation is multiplication of the original and time lagged signal values
        for(int i = 0; i < samples.length - period; i++) {
            sum += samples[i]*samples[i + period];
        }
        //find the average value of the sum
        double mean = sum / (double)samples.length;
        //and put it into results as a value for some time lag. 
        //You subtract the nLowPeriodInSamples for the index to start from 0.
        results[period - nLowPeriodInSamples] = mean;
    }
    //Now, it is obvious that the mean will be highest for time lag equal to the periodicity of the signal because in that case
    //most of the positive values will be multiplied with other positive and most of the negative values will be multiplied with other
    //negative resulting again as positive numbers and the sum will be high positive number. For example, in the other case, for let's say half period
    //autocorrelation will multiply negative with positive values resulting as negatives and you will get low value for the sum.        
    double fBestValue = Double.MIN_VALUE;
    int nBestIndex = -1; //the index is the time lag
    //So
    //The autocorrelation is highest at the periodicity of the signal
    //The periodicity of the signal can be transformed to frequency
    for(int i = 0; i < results.length; i++) {
        if(results[i] > fBestValue) {
            nBestIndex = i; 
            fBestValue = results[i]; 
        }
    }
    //Convert the period in samples to frequency and you got yourself a fundamental frequency of a sound
    double res = as.getSamplingRate() / (nBestIndex + nLowPeriodInSamples)

    return res;
}