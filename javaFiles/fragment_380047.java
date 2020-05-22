public class JNATest {

    public static void main(String[] args) {
        W32API.UINT_PTR uiAction = new W32API.UINT_PTR(User32.SPI_GETSCREENSAVERRUNNING);
        W32API.UINT_PTR uiParam = new W32API.UINT_PTR(0);
        W32API.UINT_PTR fWinIni = new W32API.UINT_PTR(0);
        PointerByReference pointer = new PointerByReference();

        User32.INSTANCE.SystemParametersInfo(uiAction, uiParam, pointer, fWinIni);

        boolean running = pointer.getPointer().getByte(0) == 1;

        System.out.println("Screen saver running: "+running);
    }
}


public interface User32 extends W32API {

    User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, DEFAULT_OPTIONS);

    long SPI_GETSCREENSAVERRUNNING = 0x0072;

    boolean SystemParametersInfo(
        UINT_PTR uiAction,
        UINT_PTR uiParam,
        PointerByReference pvParam,
        UINT_PTR fWinIni
      );


}