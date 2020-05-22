//set up
long total=0;
const long half = 32768; //2^(n-1)
const long decayInMilliseconds=30; // 30ms for the needle to fall back to zero.
// leak rate is enough to get the reported signal to decay to zero decayMilliseconds after 
// the actual amplitude goes to zero.
int leakRate = (sample_rate*1000 /decayInMilliseconds) * half; 


// goes in a loop to do the work
// can be executed on buffer-loads of data at less than the sampling rate, but the net number of calls to it persecond needs to equal the sampling rate.

int amplitude = buffer[i]-half;
total = total + abs(amplitude);
total = total - leakRate;
if( total > half) {
    total = half;
}
//total is the current "vu level".