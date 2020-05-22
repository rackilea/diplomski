Bitmap tImage = new Bitmap(Image URL goes here);
byte[] bStream = ImageToByte(tImage);

while (true)
{
TcpClient client = server.AcceptTcpClient();
Console.WriteLine("Connected");
while (client.Connected)
{
NetworkStream nStream = client.GetStream();
nStream.Write(bStream, 0,
bStream.Length);
}
}