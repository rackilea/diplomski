/* This method takes a BufferedImage encoded with TYPE_INT_ARGB and copies the pixel values into an image encoded with TYPE_4BYTE_ABGR.*/
public static void IntToByte(BufferedImage source, BufferedImage result)
    {
    final byte[] bb = ((DataBufferByte)result.getRaster().getDataBuffer()).getData() ;
    final int[] ib  = ((DataBufferInt)source.getRaster().getDataBuffer()).getData() ;

    switch ( source.getType() )
        {
        case BufferedImage.TYPE_INT_ARGB :
            for (int i=0, b=0 ; i < ib.length ; i++, b+=4)
                {
                int p   = ib[i] ;
                bb[b]   = (byte)((p & 0xFF000000) >> 24) ;
                bb[b+3] = (byte)((p & 0xFF0000) >> 16) ;
                bb[b+2] = (byte)((p & 0xFF00) >> 8) ;
                bb[b+1] = (byte)( p & 0xFF) ;
                }
            break ;
        // Many other case to manage...
        }
    }