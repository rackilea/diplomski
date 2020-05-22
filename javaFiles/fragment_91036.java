Pointer modules = new Memory(Pointer.SIZE * length);
int offset = 0;
for (h: hmodules) {
    modules.setPointer(Pointer.SIZE * offset, h.getPointer())
    offset += 1;
}