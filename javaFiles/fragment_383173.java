_in = new BinaryReader(stream, Encoding.UTF8);
byte[] header = _in.ReadBytes(2);
short count = BitConverter.ToInt16(header, 0);
byte[] data = _in.ReadBytes(count);
string text = Encoding.UTF8.GetString(data);
Console.WriteLine(text); // outputs something