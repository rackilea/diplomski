/**
 * Name of the MTP USB function.
 * Used in extras for the {@link #ACTION_USB_STATE} broadcast
 *
 * {@hide}
 */
public static final String USB_FUNCTION_MTP = "mtp";

/**
 * Name of the PTP USB function.
 * Used in extras for the {@link #ACTION_USB_STATE} broadcast
 *
 * {@hide}
 */
public static final String USB_FUNCTION_PTP = "ptp";


 /**
     * Returns the current default USB function.
     *
     * @return name of the default function.
     *
     * {@hide}
     */
    public String getDefaultFunction() {
        String functions = SystemProperties.get("persist.sys.usb.config", "");
        int commaIndex = functions.indexOf(',');
        if (commaIndex > 0) {
            return functions.substring(0, commaIndex);
        } else {
            return functions;
        }
    }

    /**
     * Sets the current USB function.
     * If function is null, then the current function is set to the default function.
     *
     * @param function name of the USB function, or null to restore the default function
     * @param makeDefault true if the function should be set as the new default function
     *
     * {@hide}
     */
    public void setCurrentFunction(String function, boolean makeDefault) {
        try {
            mService.setCurrentFunction(function, makeDefault);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in setCurrentFunction", e);
        }
    }