public int read(int z) throws IOException
{
  int c = super.read();
  if(c == -1) return -1;
  return (c^z) & 0xFF; /* Only use lowest 8 bits */
}