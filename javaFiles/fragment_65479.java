public static LRESULT SendMessage(HWND hWnd, UINT Msg, WPARAM wParam, LPARAM lParam) throws NativeException, IllegalAccessException
{
    JNative SendMessage = new JNative(DLL_NAME, "SendMessageA");
    SendMessage.setRetVal(Type.INT);
    int pos = 0;
    SendMessage.setParameter(pos++, hWnd.getValue());
    SendMessage.setParameter(pos++, Msg.getValue());
    SendMessage.setParameter(pos++, wParam.getValue());
    SendMessage.setParameter(pos++, lParam.getValue());
    SendMessage.invoke();
    pos = SendMessage.getRetValAsInt();
    SendMessage.dispose();
    return new LRESULT(pos);
}