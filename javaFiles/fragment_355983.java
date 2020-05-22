FileChannel fc = new FileInputStream("C:/Dane DMS/"+names2).getChannel();
ByteBuffer bb = ByteBuffer.allocateDirect((int) fc.size());
while (bb.remaining() > 0) fc.read(bb);
fc.close();
bb.flip();
// choose the right endianness
ShortBuffer sb = bb.order(ByteOrder.BIG_ENDIAN).asShortBuffer();

short[][] Matrix = new short[1201][1201];
for(int i = 0; i<=1200; i++)
{
    for(int j = 0; j<=1200 ; j++)
    {
        Matrix[1200-i][j] = sb.get(i*1201+j);
    }
}