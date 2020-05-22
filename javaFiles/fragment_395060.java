int length = s.length;
int blockOffsetIndex = length - BLOCK_OFFSET_LENGTH;
blockOffset = s.substring(blockOffsetIndex  - 1, length );

int indexIndex = blockOffsetIndex - INDEX_LENGTH;
indexStr = s.substring(indexIndex - 1, indexIndex + INDEX_LENGHT);

rest = s.substring(0, indexIndex -1);