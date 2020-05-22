public BufferedImage Inverse_DCT (BufferedImage img){
int width = img.getWidth();
int height = img.getHeight();
BufferedImage OutputImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

// ------------------- IDCT Implementation ------------------------------
double [][]Cos_Basis = new double [8][8]; // 8X8 Cosine Basis Implementation
//double [] CoEff = new double [8];
double Cu,Cv;
// ------------------ Pre Compute The Kernel ---------------------------
for (int i=0;i<8;i++)
{   
    for (int j=0;j<8;j++)
    {
        Cos_Basis[i][j] =  Math.cos((2*i+1)*j*3.14159f/16.0f); // COSINE KERNEL
    }
    //if (i==0)
    //    CoEff[i]=1/(Math.sqrt(2));
    //else
    //    CoEff[i]=1;             
}
// -------------------- IDCT Code --------------------------------------
for (int row=0;row<(height);row+=8)
{
    for (int col=0;col<(width);col+=8)
    {
        for (int i=0;i<8;i++) // Block Row
        {
            for (int j=0;j<8;j++) // Block Col
            {
               double sumR = 0;double sumG = 0;double sumB = 0;
               for (int x=0;x<8;x++)
               {
                   for (int y=0;y<8;y++)
                   {  
                       if (x==0) {Cu = (1/(Math.sqrt(2)));}
                       else { Cu = 1;}

                       if (y==0) {Cv = (1/(Math.sqrt(2)));}
                       else { Cv = 1;} 

                       sumR += (Cu)*(Cv)*((((img.getRGB((col+y),(row+x))>>16) & 0xFF))*(Cos_Basis[i][x])*(Cos_Basis[j][y]));
                       sumG += (Cu)*(Cv)*((((img.getRGB((col+y),(row+x))>>8) & 0xFF))*(Cos_Basis[i][x])*(Cos_Basis[j][y]));
                       sumB += (Cu)*(Cv)*((((img.getRGB((col+y),(row+x))>>0) & 0xFF))*(Cos_Basis[i][x])*(Cos_Basis[j][y]));
                   }
               }

               sumR *= 0.25f; 
               sumG *= 0.25f; 
               sumB *= 0.25f; 
               if (sumR<0) sumR=0; if (sumG<0) sumG=0;if (sumB<0) sumB=0;
               if (sumR>255) sumR=255; if (sumG>255) sumG=255;if (sumB>255) sumB=255;
               //System.out.println("SumR : "+sumR+"  SumG:"+sumG+" SumB:"+sumB);
               // Assign Output Image
               int pix = 0xff000000 | (((int)(sumR) & 0xff) << 16) | (((int)(sumG) & 0xff) << 8) | ((int)(sumB) & 0xff);
               //System.out.println("PIXEL : "+pix);
               OutputImage.setRGB((col+j),(row+i),pix);
            }
        }
    }
}
return OutputImage;
}