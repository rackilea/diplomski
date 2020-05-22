import com.google.gwt.event.dom.client.KeyCodes;
    import com.google.gwt.i18n.client.DateTimeFormat;
    import com.google.gwt.user.client.Event;
    import com.google.gwt.user.client.Event.NativePreviewEvent;

    ...


    Event.addNativePreviewHandler(new Event.NativePreviewHandler() {

        @Override
        public void onPreviewNativeEvent(final NativePreviewEvent event) {
            if (event.getTypeInt() == Event.ONKEYPRESS) {
                if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_BACKSPACE) {
                    System.out.println("Back space is pressed");
                }
            }
        }
    });

    t1.sinkEvents(Event.ONKEYPRESS);