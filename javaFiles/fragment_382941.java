/**
  * increase bytes of current block by len.
  *
  * @param len how many bytes to increase to current block
  */
void incBytesCurBlock(long len) {
    this.bytesCurBlock += len;
}