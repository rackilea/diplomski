public class ChunkConflictResolver implements ConflictResolver<Chunk> {

    public Chunk resolve(List<Chunk> siblings) throws UnresolvedConflictException {
        if (siblings == null) {
            return null;
        }
        Chunk oneChunk = siblings.get(0);
        // finally, the key!
        String key = oneChunk.chunkId;
        ...
    }
}