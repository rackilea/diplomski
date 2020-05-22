byte[] bytes = new byte[1024];
final DataInputStream in = new DataInputStream(s.getInputStream());

int length = in.readInt();
if (length > bytes.length) bytes = new byte[length];
in.readFully(bytes, 0, length); // read length bytes or throw an exception.