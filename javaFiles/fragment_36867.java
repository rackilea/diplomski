public void read() {
    Memory old = getPointer();
    Memory m = autoAllocate(size());
    // horribly inefficient, but it'll do
    m.write(0, old.getByteArray(0, size()), 0, size());
    useMemory(m);
    // Zero out the problematic callbacks
    for (field : problematic_fields) {
        m.setPointer(field_offset, null);
    }
    super.read();
    useMemory(old);
}