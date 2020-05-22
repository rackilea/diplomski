final static int MAPVK_VK_TO_VSC = 0;
static IntByReference _currentInputLocaleIdentifier; 

static interface User32 extends Library {

    public static User32 INSTANCE = (User32) Native.loadLibrary("User32", User32.class);


    IntByReference GetKeyboardLayout(int dwLayout);
    int MapVirtualKeyExW (int uCode, int nMapType, IntByReference dwhkl);

    boolean GetKeyboardState(byte[] lpKeyState);

    int ToUnicodeEx(int wVirtKey, int wScanCode, byte[] lpKeyState, char[] pwszBuff, int cchBuff, int wFlags, IntByReference dwhkl);

}