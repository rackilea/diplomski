209    public byte[]  [More ...] getData()
210    {
211        if (memoryOutputStream != null)
212        {
213            return memoryOutputStream.toByteArray();
214        }
215        return null;
216    }