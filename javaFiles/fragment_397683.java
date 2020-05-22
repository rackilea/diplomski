public class ReadExample
{
   public static void main(String[] args)
   {
      try
      {
         // Open the wav file specified as the first argument
         WavFile wavFile = WavFile.openWavFile(new File(args[0]));

         // Get the number of audio channels in the wav file
         int numChannels = wavFile.getNumChannels();

         // Create a buffer of 100 frames
         double[] buffer = new double[100 * numChannels];

         int framesRead;

         do
         {
            // Read frames into buffer
            framesRead = wavFile.readFrames(buffer, 100);

            // Loop through frames and look for minimum and maximum value
            for (int s=0 ; s<framesRead * numChannels ; s++)
            {
               //This is where you put the your code in
            }
         }
         while (framesRead != 0);

         // Close the wavFile
         wavFile.close();
      }
      catch (Exception e)
      {
         System.err.println(e);
      }
   }
}