public class Chunk {

    @RiakKey
    public String   chunkId;

    public byte[]   data;
}