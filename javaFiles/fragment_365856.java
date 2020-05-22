@Override
public void executeMessage(Message message) {
    switch (message.what) {
        case DO_ON_ACCESSIBILITY_EVENT: {
            AccessibilityEvent event = (AccessibilityEvent) message.obj;
            if (event != null) {
                AccessibilityInteractionClient.getInstance().onAccessibilityEvent(event);
                mCallback.onAccessibilityEvent(event);
                try {
                    //EVENT IS RECYCLED BEFORE THE ONNEXT IS CALLED IN MY PUBLISHSUBJECT
                    event.recycle();
                } catch (IllegalStateException ise) {
                }
            }
        } return;
... bla bla