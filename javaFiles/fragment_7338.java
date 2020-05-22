public class BinaryLoader
{
    static
        { load_binaries(); }

    public static void load_binaries()
    {
        // Deep inside here is a call to actually load the shared library. Using
        load_shared_library_from_jar("PROJECT");
    }
 ... // more details here
 }