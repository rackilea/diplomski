protected byte[] clearBuffer() {
    byte[] ret = new byte[getBufferSize()];
    int index = 0;
    for (byte[] b : buffer)
    {
        if (b != null)
        {
            for (int i=0; i<b.length; i++)
            {
                ret[index] = b[i];
            }
        }
    }
    buffer.clear();
    return ret;
}