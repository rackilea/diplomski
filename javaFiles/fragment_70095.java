for (int i = 0; i < sliceCount; i++)
 {
     for (int j = 0 ; j < frequencies.length; j++)
     {
         slices[i] += Math.sin(2*Math.PI*i*frequencies[i]/StdAudio.SAMPLE_RATE);
     }
     slices[i] /= frequencies.length; // renormalize to between -1 and 1
 }