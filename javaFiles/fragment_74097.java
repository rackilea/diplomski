UINT
AwtToolkit::MessageLoop(IDLEPROC lpIdleFunc,
                        PEEKMESSAGEPROC lpPeekMessageFunc)
{
    ...

    m_messageLoopResult = 0;
    while (!m_breakMessageLoop) {

        (*lpIdleFunc)();

        PumpWaitingMessages(lpPeekMessageFunc); /* pumps waiting messages */
        ...
    }
    ...
}