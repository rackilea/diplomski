import org.xvolks.jnative.misc.basicStructures.*;
...

User32.SendMessage(
    new HWND(ValidHWND),
    new UINT(WM_SYSCOMMAND), 
    new WPARAM(SC_MONITORPOWER),
    new LPARAM(MONITOR_STANDBY);