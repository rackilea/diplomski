interface ExtendedStdLib extends StdCallLibrary {
    ExtendedStdLib INSTANCE = (ExtendedStdLib) Native.load("user32", ExtendedStdLib.class);
    int WM_SETTEXT = 0x000c;
    int WM_GETTEXT = 0x000D;

    HWND FindWindowA(String lpClassName, String lpWindowName);
    HWND FindWindowExA(HWND hwndParent, HWND hwndChildAfter, String lpClassName,
                       String lpWindowName);
    LRESULT SendMessageA(HWND paramHWND, int paramInt, WPARAM paramWPARAM, LPARAM paramLPARAM);
    LRESULT SendMessageA(HWND editHwnd, int wmGettext, long l, byte[] lParamStr);
    int GetClassNameA(HWND hWnd, byte[] lpString, int maxCount);
}

public void getSelectableText() {
    ExtendedStdLib EXT_INSTANCE = ExtendedStdLib.INSTANCE;

    HWND zavhwnd = User32.INSTANCE.FindWindow(null, "{Window Title}");
    if (zavhwnd == null) {
        log.error("Window wasn't found");
        return;
    }

    User32.INSTANCE.EnumChildWindows(zavhwnd, (hwnd, pntr) -> {
        char[] textBuffer = new char[512];
        char[] textBuffer2 = new char[512];
        User32.INSTANCE.GetClassName(hwnd, textBuffer, 512);
        User32.INSTANCE.GetWindowText(hwnd, textBuffer2, 512);
        String wText = Native.toString(textBuffer);
        String wText2 = Native.toString(textBuffer2);
        if (wText.contains("RichEdit")) {
            byte[] lParamStr = new byte[2048];
            LRESULT resultBool = EXT_INSTANCE.SendMessageA(hwnd, ExtendedStdLib.WM_GETTEXT, 2048, lParamStr);
            String text = Native.toString(lParamStr, "windows-1250");
        }
        return true;
    }, null);
}