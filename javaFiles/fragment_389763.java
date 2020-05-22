final int level = 9;
final boolean nowrap = true;

// compress
final Deflater def = new Deflater(level, nowrap);
final byte[] abcd = new byte[] { 0x41, 0x42, 0x43, 0x44 };
def.setDictionary(abcd);
def.setInput(abcd);
def.finish();
final byte[] buf = new byte[1024];
final int nbytes = def.deflate(buf);
assert def.finished();
def.end();

// decompress
final Inflater inf = new Inflater(nowrap);
inf.setDictionary(abcd);
inf.setInput(buf); // include extra "dummy" byte
while (inf.inflate(buf) != 0) {
    // discard
}
assert !inf.needsInput();
assert inf.needsDictionary();
inf.end();