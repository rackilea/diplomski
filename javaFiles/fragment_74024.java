@Override
public void onAccessibilityEvent(AccessibilityEvent e) {

    switch (e.getEventType()) {
        //This event alone may be enough!
        case AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED:

        // If not fall through for these events as well, which would detect things like a "Copy" button activated.
        case AccessibilityEvent.TYPE_VIEW_CLICKED:
        case AccessibilityEvent.TYPE_VIEW_CONTEXT_CLICKED:
            checkContentsOfClipboard();

    }
}