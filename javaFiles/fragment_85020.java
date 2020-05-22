public static BufferedImage capture(Pointer hWnd2, String wText) {
    HWND hWnd = new HWND(hWnd2);
    boolean success;
    if(User32Extra.INSTANCE.IsIconic(hWnd))
    {
        success= User32Extra.INSTANCE.ShowWindow(hWnd, 4);
        System.err.println(success);
        System.err.println(wText+Native.getLastError());
    }
    HDC hdcWindow2 = User32.INSTANCE.GetDC(hWnd);
    final HDC hdcMemDC = GDI32.INSTANCE.CreateCompatibleDC(hdcWindow2);

    RECT bounds = new RECT();
    RECT bounds1 = new RECT();
    User32Extra.INSTANCE.GetWindowRect(hWnd, bounds);
    User32Extra.INSTANCE.GetClientRect(hWnd, bounds1);

    int extraGap = (bounds.right-bounds.left-bounds1.right);
    int width = bounds.right-bounds.left-extraGap;
    int height = bounds.bottom-bounds.top-extraGap ;
    HBITMAP hBitmap = GDI32.INSTANCE.CreateCompatibleBitmap(hdcWindow2, width, height);

    HANDLE hOld = GDI32.INSTANCE.SelectObject(hdcMemDC, hBitmap);
    GDI32Extra.INSTANCE.BitBlt(hdcMemDC,0, 0, width, height, hdcWindow2, bounds.left+bounds1.right-bounds.right+extraGap, bounds.top+bounds1.bottom-bounds.bottom+extraGap, WinGDIExtra.SRCCOPY);

    // Popup menu doesn't have parent, so we could encounter situation when context menu from another window is overlapping our target window
    // Since context menu enforces our window to focus, we can check here if our window is foreground window (otherwise it is not possible to have opened context menu)
    if (User32.INSTANCE.GetForegroundWindow() == hWnd)
    {
        final RECT windowBounds = bounds;
        // Enum all windows and check if they have class #32768
        User32.INSTANCE.EnumWindows(new WNDENUMPROC() {
            @Override
            public boolean callback(HWND hMenuWnd, Pointer arg1) {
                byte[] windowClass = new byte[8];
                User32.INSTANCE.GetClassNameA(hMenuWnd, windowClass, 8);
                String wClass = Native.toString(windowClass);
                // #32768 is class name for popup menus.
                if (wClass.equals("#32768"))
                {
                    HDC hdcWindowMenu = User32.INSTANCE.GetDC(hMenuWnd);
                    RECT menuBounds = new RECT();
                    User32Extra.INSTANCE.GetWindowRect(hMenuWnd, menuBounds);
                    GDI32Extra.INSTANCE.BitBlt(hdcMemDC, menuBounds.left - windowBounds.left, menuBounds.top - windowBounds.top, menuBounds.right-menuBounds.left, menuBounds.bottom-menuBounds.top, hdcWindowMenu, 0, 0, WinGDIExtra.SRCCOPY);
                    User32.INSTANCE.ReleaseDC(hMenuWnd, hdcWindowMenu);
                }
                return true;
            }
        }, null);
    }

    GDI32.INSTANCE.SelectObject(hdcMemDC, hOld);

    BITMAPINFO bmi = new BITMAPINFO();
    bmi.bmiHeader.biWidth = width;
    bmi.bmiHeader.biHeight = -height;
    bmi.bmiHeader.biPlanes = 1;
    bmi.bmiHeader.biBitCount = 32;
    bmi.bmiHeader.biCompression = WinGDI.BI_RGB;
    Memory buffer = new Memory(width * height * 4);
    GDI32.INSTANCE.GetDIBits(hdcWindow2, hBitmap, 0, height, buffer, bmi, WinGDI.DIB_RGB_COLORS);

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    GDI32.INSTANCE.DeleteObject(hBitmap);
    GDI32.INSTANCE.DeleteDC(hdcMemDC);
    User32.INSTANCE.ReleaseDC(hWnd, hdcWindow2);

    return image;
}