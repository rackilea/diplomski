while (in.read(bb) > 0 || bb.position() > 0)
{
    bb.flip();
    out.write(bb);
    bb.compact();
}