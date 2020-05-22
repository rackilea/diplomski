public class JNA_Test2 {

    public static void main(String[] args) {
        Pointer foundWindowPointer = new Memory(Pointer.SIZE);
        JNA_Test2.isWindowOpen("chrome", foundWindowPointer);
        if (foundWindowPointer.getPointer(0) != null) {
            HWND foundWindow = new HWND(foundWindowPointer.getPointer(0));
            JNA_Test2.activateWindow(foundWindow);
        }
    }

    public static void activateWindow(HWND foundWindow) {
        if (foundWindow != null) {
            User32.INSTANCE.ShowWindow(foundWindow, 9);
            User32.INSTANCE.SetForegroundWindow(foundWindow);
        }
    }

    public static void isWindowOpen(String title, Pointer foundWindowPointer) {
        User32.INSTANCE.EnumWindows(new WNDENUMPROC() {

            @Override
            public boolean callback(HWND hWnd, Pointer foundWindowPointer) {
                if (foundWindowPointer != null) {
                    char[] windowText = new char[512];
                    User32.INSTANCE.GetWindowText(hWnd, windowText, 512);
                    String wText = Native.toString(windowText);
                    if (wText.contains(title)) {
                        foundWindowPointer.setPointer(0, hWnd.getPointer());
                    }
                }
                return true;

            }
        }, foundWindowPointer);
    }
}