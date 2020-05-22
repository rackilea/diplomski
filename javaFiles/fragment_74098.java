/*
 * Called by the message loop to pump the message queue when there are
 * messages waiting. Can also be called anywhere to pump messages.
 */
BOOL AwtToolkit::PumpWaitingMessages(PEEKMESSAGEPROC lpPeekMessageFunc)
{
    MSG  msg;
    BOOL foundOne = FALSE;
    ...

    while (!m_breakMessageLoop && (*lpPeekMessageFunc)(msg)) {
        foundOne = TRUE;
        ProcessMsg(msg); // calls TranslateMessage & DispatchMessage (below)
    }
    return foundOne;
}

void AwtToolkit::ProcessMsg(MSG& msg)
{
    if (msg.message == WM_QUIT) {
        ...
    }
    else if (msg.message != WM_NULL) {
        ...

        ::TranslateMessage(&msg);
        ::DispatchMessage(&msg);
    }
}