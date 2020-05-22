public static int transferAsMuchAsPossible(
                     ByteBuffer bbuf_dest, ByteBuffer bbuf_src)
{
  int nTransfer = Math.min(bbuf_dest.remaining(), bbuf_src.remaining());
  if (nTransfer > 0)
  {
    bbuf_dest.put(bbuf_src.array(), 
                  bbuf_src.arrayOffset()+bbuf_src.position(), 
                  nTransfer);
    bbuf_src.position(bbuf_src.position()+nTransfer);
  }
  return nTransfer;
}