BufferedImage img= ImageIO.read(new File("image.png"));

final int w= 10;
final int h= 10;
final int rows = 5;
final int cols = 5;
BufferedImage[] tile= new BufferedImage[rows * cols];

for (int i = 0; i < rows; i++)
{
    for (int j = 0; j < cols; j++)
    {
        tile[(i * cols) + j] = img.getSubimage(
            j * w,
            i * h,
            w,
            h
        );
    }
}