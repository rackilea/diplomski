import java.io.File;
import java.io.IOException;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT.HANDLE;

public class WindowsFileOps {
    private WindowsFileOps() {}


    private static interface Kernel32Extra extends StdCallLibrary {
        int COMPRESSION_FORMAT_NONE = 0x00000000;
        int COMPRESSION_FORMAT_DEFAULT = 0x00000001;
        int FSCTL_SET_COMPRESSION = 0x0009C040;

        Kernel32Extra INSTANCE = (Kernel32Extra)Native.loadLibrary("kernel32",
            Kernel32Extra.class, W32APIOptions.UNICODE_OPTIONS);

        boolean GetVolumeInformation(
            String lpRootPathName,
            Pointer lpVolumeNameBuffer,
            int nVolumeNameSize,
            IntByReference lpVolumeSerialNumber,
            IntByReference lpMaximumComponentLength,
            IntByReference lpFileSystemFlags,
            Pointer lpFileSystemNameBuffer,
            int nFileSystemNameSize
        );
    }


    private static Boolean isAvailable;
    public static boolean isAvailable() {
        if (isAvailable == null) {
            try {
                isAvailable = Kernel32.INSTANCE != null && Kernel32Extra.INSTANCE != null;
            } catch (Throwable t) {
                isAvailable = false;
            }
        }
        return isAvailable;
    }


    private static String pathString(File file) {
        // "\\?\" is a Windows API thing that enables paths longer than 260 chars
        return "\\\\?\\" + file.getAbsolutePath();
    }


    private static int getAttributes(File file) throws IOException {
        int attrib = Kernel32.INSTANCE.GetFileAttributes(pathString(file));
        if (attrib == Kernel32.INVALID_FILE_ATTRIBUTES) {
            throw new IOException("Unable to read file attributes of " + file);
        }
        return attrib;
    }


    public static boolean isCompressed(File file) throws IOException {
        return (getAttributes(file) & Kernel32.FILE_ATTRIBUTE_COMPRESSED) != 0;
    }


    public static void setCompressed(File file, boolean compressed) throws IOException {
        HANDLE hFile = Kernel32.INSTANCE.CreateFile(
            pathString(file),
            Kernel32.GENERIC_READ | Kernel32.GENERIC_WRITE,
            Kernel32.FILE_SHARE_READ,
            null,
            Kernel32.OPEN_EXISTING,
            0,
            null);
        try {
            if (!Kernel32.INSTANCE.DeviceIoControl(
                hFile,
                Kernel32Extra.FSCTL_SET_COMPRESSION,
                new ShortByReference((short)(
                    compressed
                        ? Kernel32Extra.COMPRESSION_FORMAT_DEFAULT
                        : Kernel32Extra.COMPRESSION_FORMAT_NONE
                )).getPointer(),
                2,
                null, 0,
                new IntByReference(),
                null
            )) throw new IOException("Unable to alter compression attribute of " + file);
        } finally {
            Kernel32.INSTANCE.CloseHandle(hFile);
        }
    }


    public static boolean volumeSupportsFileCompression(File file) throws IOException {
        IntByReference flags = new IntByReference();
        if (!Kernel32Extra.INSTANCE.GetVolumeInformation(
            pathString(file.getAbsoluteFile().toPath().getRoot().toFile()),
            null, 0,
            null,
            null,
            flags,
            null, 0
        )) throw new IOException("GetVolumeInformation failure");
        return (flags.getValue() & Kernel32.FILE_FILE_COMPRESSION) != 0;
    }
}