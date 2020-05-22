public Image<Bgr, Byte> byteArrayToImage(byte[] byteArrayIn)
{
 MemoryStream ms = new MemoryStream(byteArrayIn);
 Bitmap returnImage = Image.FromStream(ms);

 return new Image<Bgr, byte>(returnImage);
 // you probably need to clean up stuff like the bitmap and the stream...
}