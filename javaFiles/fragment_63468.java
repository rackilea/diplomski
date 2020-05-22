static byte[] ImageToByte(System.Drawing.Image iImage)
{
MemoryStream mMemoryStream = new MemoryStream();
iImage.Save(mMemoryStream,
System.Drawing.Imaging.ImageFormat.Gif);
return mMemoryStream.ToArray();
}