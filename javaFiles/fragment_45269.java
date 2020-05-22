ByteArrayOutputStream baos = new ByteArrayOutputStream();

int size;
byte[] bytes = new byte[4096];

while (size = is.read(bytes, 0, bytes.length) != -1)
{
    baos.write(bytes, 0, size);
}
baos.flush();
String s = baos.toString();