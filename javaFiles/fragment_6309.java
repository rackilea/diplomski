public class Convolution
{
    public static void main(String[] args)
    {
        int image[] = { 0,1,2,3,4,5,6,7,8 };
        int kernel[] = { 0,1,2,3,4,5,6,7,8 };

        int output[] = convolve(image, kernel);

        for (int i=0; i<image.length; i++)
        {
            System.out.printf(output[i]+" ");
        }
    }

    public static int[] convolve(int[] image, int[] kernel)
    {       
        int[] output = new int[image.length];

        // loop through image
        for(int i = 0; i < image.length; i++)
        {      
            System.out.println("Compute output["+i+"]");
            int outputValue = 0;

            // loop through kernel
            for(int j = 0; j < kernel.length; j++)
            {
                int neighbour = i + j - (kernel.length / 2);

                // discard out of bound neighbours 
                if (neighbour >= 0 && neighbour < image.length)
                {
                    int imageValue = image[neighbour];
                    int kernelValue = kernel[j];          
                    outputValue += imageValue * kernelValue;

                    System.out.println("image["+neighbour+"] and kernel["+j+"]");
                }
            }

            output[i] = outputValue;
        }        

        return output;
    }
}