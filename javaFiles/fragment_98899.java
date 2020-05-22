public class JNA_Test {
    HWND foundWindow = null;

    public static void main(String[] args) {
        JNA_Test jna = new JNA_Test();
        if(jna.isWindowOpen("chrome")){
            jna.activateWindow();
        }
    }

    public void activateWindow() {
        if(foundWindow != null) {
            User32.INSTANCE.ShowWindow(foundWindow, 9);
            User32.INSTANCE.SetForegroundWindow(foundWindow);
        }
    }

    public boolean isWindowOpen(String title) {
        foundWindow = null;
        User32.INSTANCE.EnumWindows(new WNDENUMPROC() {

            @Override
            public boolean callback(HWND hWnd, Pointer arg1) {
                if(foundWindow == null) {
                    char[] windowText = new char[512];
                    User32.INSTANCE.GetWindowText(hWnd, windowText, 512);
                    String wText = Native.toString(windowText);
                    if (wText.contains(title)) {
                        foundWindow = hWnd;
                    }
                }
                return true;

            }
        }, null);

        return foundWindow != null;
    }
}