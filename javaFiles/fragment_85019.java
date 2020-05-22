public static BufferedImage capture(Pointer hWnd2, String wText) {
   HWND hWnd = new HWND(hWnd2);
   boolean success;
   if(User32Extra.INSTANCE.IsIconic(hWnd))
   {
       success= User32Extra.INSTANCE.ShowWindow(hWnd, 4);
       System.err.println(success);
       System.err.println(wText+Native.getLastError());
   }
   // Pass GetDesktopWindow instead of target HWND to GetDC
   HDC hdcWindow2 = User32.INSTANCE.GetDC(User32.INSTANCE.GetDesktopWindow());
   HDC hdcMemDC = GDI32.INSTANCE.CreateCompatibleDC(hdcWindow2);

   RECT bounds = new RECT();
   //RECT bounds1 = new RECT();
   User32Extra.INSTANCE.GetWindowRect(hWnd, bounds);
   //User32Extra.INSTANCE.GetClientRect(hWnd, bounds1);

   //int extraGap = (bounds.right-bounds.left-bounds1.right);
   int width = bounds.right-bounds.left;
   int height = bounds.bottom-bounds.top;
   HBITMAP hBitmap = GDI32.INSTANCE.CreateCompatibleBitmap(hdcWindow2, width, height);

   HANDLE hOld = GDI32.INSTANCE.SelectObject(hdcMemDC, hBitmap);
   GDI32Extra.INSTANCE.BitBlt(hdcMemDC,0, 0, width, height, hdcWindow2, bounds.left, bounds.top, WinGDIExtra.SRCCOPY);
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