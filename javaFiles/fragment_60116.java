interface NativeExample extends Library {
    NativeExample ne = (NativeExample) Native.loadLibrary("foo", NativeExample.class);

    Pointer decrypt(String value);
    void free_decrypted_string(Pointer str);
}

public class Main {
    public static void main(String[] args) {
        Pointer decrypted = NativeExample.ne.decrypt("foo");
        System.out.println(decrypted.getString(0));
        NativeExample.ne.free_decrypted_string(decrypted);
    }
}