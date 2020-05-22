// Original C declaration
void allocate_buffer(char **bufp, int* lenp);

// Equivalent JNA mapping
void allocate_buffer(PointerByReference bufp, IntByReference lenp);

// Usage
PointerByReference pref = new PointerByReference();
IntByReference iref = new IntByReference();
lib.allocate_buffer(pref, iref);
Pointer p = pref.getValue();
byte[] buffer = p.getByteArray(0, iref.getValue());