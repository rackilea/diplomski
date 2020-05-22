interface NativeExample extends Library {
    NativeExample ne = (NativeExample) Native.loadLibrary("foo", NativeExample.class);

    FreeableString decrypt(String value);
    void free_decrypted_string(FreeableString str);

    class FreeableString extends PointerType implements AutoCloseable {
        @Override
        public void close() {
            ne.free_decrypted_string(this);
        }
        public String getString() {
            return this.getPointer().getString(0);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try (NativeExample.FreeableString decrypted = NativeExample.ne.decrypt("foo")) {
            System.out.println(decrypted.getString());
        }
    }
}