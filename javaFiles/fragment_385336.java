public static native void testNativeAlert()/*-{

   $wnd.navigator.notification.alert(
    'You are the winner!',  // message
    null,         // callback
    'Game Over',
    'Done');
}-*/;