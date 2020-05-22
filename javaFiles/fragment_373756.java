Memory memory = new Memory(40);
PointerByReference data = new PointerByReference();
data.setValue(memory);
// call the function now
byte[] bytes = new byte[40];
memory.read(0, bytes, 0, 40);