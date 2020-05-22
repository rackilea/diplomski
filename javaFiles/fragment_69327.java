public abstract class Color{
    public static final float[] xyz2sRGB;
      static
      {
        xyz2sRGB= new float[9];
        xyz2sRGB[0] = 3.241F;
        xyz2sRGB[1] = -0.9692F;
        xyz2sRGB[2] = 0.0556F;
        xyz2sRGB[3] = -1.5374F;
        xyz2sRGB[4] = 1.876F;
        xyz2sRGB[5] = -0.204F;
        xyz2sRGB[6] = -0.4986F;
        xyz2sRGB[7] = 0.0416F;
        xyz2sRGB[8] = 1.057F;
      } 
}