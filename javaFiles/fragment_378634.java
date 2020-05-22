ByteBuffer(int mark, int pos, int lim, int cap,   // package-private
274                  byte[] hb, int offset)
275     {
276         super(mark, pos, lim, cap);
277         this.hb = hb;
278         this.offset = offset;
279     }
280