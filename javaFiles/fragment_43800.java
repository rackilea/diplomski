AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
            (float)44.1,       //samplerate
            16,                //sampleSizeInBits
            2,                 //channels
            626,               //frameSize
            (float)38.4615385, //frameRate
            false);            //bigEndian