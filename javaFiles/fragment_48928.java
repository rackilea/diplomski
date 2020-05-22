int kb = 1024;
while (bbuf.remaining() >= kb) {

    ByteBuffer temp = bbuf.slice();
    temp.limit(1024);
    addQueue(temp);

    bbuf.position(bbuf.position() + kb);
}

if (bbuf.hasRemaining()) {
    ByteBuffer temp = bbuf.slice();
    addQueue(temp);
}