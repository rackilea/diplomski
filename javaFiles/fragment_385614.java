public static BufferedImage mat2Img(Mat in)
{
    BufferedImage out;
    byte[] data = new byte[320 * 240 * (int)in.elemSize()];
    int type;
    in.get(0, 0, data);

    if(in.channels() == 1)
        type = BufferedImage.TYPE_BYTE_GRAY;
    else
        type = BufferedImage.TYPE_3BYTE_BGR;

    out = new BufferedImage(320, 240, type);

    out.getRaster().setDataElements(0, 0, 320, 240, data);
    return out;
}