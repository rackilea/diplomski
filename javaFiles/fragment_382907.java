public static void Receive(Socket socket, byte[] buffer, int size)
{
 int received = 0;
 do
 {
  try
  {
   received += socket.Receive(buffer, received, size - received, SocketFlags.None);
  }
  catch (SocketException ex)
  {
   throw ex;  // any serious error occurr
  }
 } while (received < size);
}