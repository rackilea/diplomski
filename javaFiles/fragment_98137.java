For argument sake lets say your ...

sample_rate = 44100;  // 44.1 kHz which is typical
bit_depth = 16;       // also typical
number_of_channels = 2;  // mono --> 1   stereo --> 2

look_ahead_milli_sec = 1500; // you are given this in milliseconds

bit_rate = sample_rate * bit_depth * number_of_channels;
bit_rate = 44100 * 16 * 2;
bitrate = 1411200; // based on above calculation

bytes_per_second = bitrate / 8; // bits to bytes per sec
bytes_per_second = 1411200 / 8; // bits to bytes per sec
bytes_per_second = 176400; // bytes per sec

look_ahead_in_bytes = (bytes_per_second / 1000) * look_ahead_milli_sec;

look_ahead_in_bytes = (176400 / 1000) * 1500;    
look_ahead_in_bytes = 264600;