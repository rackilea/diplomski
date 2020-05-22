// list of blocks so you can lookup any block using a 16-bit index.
List<Block> blocks = new ArrayList<Block>();

int indexInBlocksToNext = ...
data[126] = (byte) (indexInBlocksToNext >> 8);
data[127] = (byte) indexInBlocksToNext;