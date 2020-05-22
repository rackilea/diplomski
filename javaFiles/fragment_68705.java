package com.mypackage.fragment.win64;

import org.apache.log4j.Logger;
import org.eclipse.swt.internal.win32.OS;   // yes i DO mean win32 here

import com.mypackage.ISilencer;

@SuppressWarnings("restriction")
public class Silencer implements ISilencer {

    private static final Logger LOGGER = Logger.getLogger(Silencer.class);

    @Override
    public void silence() {
        // removes the annoying browser clicking sound!
        try {
            OS.CoInternetSetFeatureEnabled(OS.FEATURE_DISABLE_NAVIGATION_SOUNDS, OS.SET_FEATURE_ON_PROCESS, true);
        } catch (Throwable e1) {
            // I am just catching any exceptions that may come off this one since it is using restricted API so that if in any case it fail well it will just click.
            LOGGER.error("Caught exception while setting FEATURE_DISABLE_NAVIGATION_SOUNDS.");
        }
    }
}