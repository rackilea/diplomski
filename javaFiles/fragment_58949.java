int count;
byte[] buffer = new byte[8192];

while (size > 0 && (count = in.read(buffer, 0, Math.min((int) size, buffer.length))) > 0) {
    size -= count;
    out.write(buffer, 0, count);
    // Progress reporting omitted.
}