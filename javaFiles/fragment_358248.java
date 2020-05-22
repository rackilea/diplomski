public static boolean isDpadDevice(InputEvent event) {
    // Check that input comes from a device with directional pads.
    if ((event.getSource() & InputDevice.SOURCE_DPAD)
         != InputDevice.SOURCE_DPAD) {
         return true;
     } else {
         return false;
     }
 }