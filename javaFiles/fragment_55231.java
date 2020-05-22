import com.sun.jna.win32.StdCallLibrary;

interface User32 extends StdCallLibrary {
    // https://msdn.microsoft.com/en-us/library/windows/desktop/ms633499(v=vs.85).aspx
    int FindWindowA(String className, String windowName);
    // https://msdn.microsoft.com/en-us/library/windows/desktop/ms633548(v=vs.85).aspx
    boolean ShowWindow(int window, int command);
}