package com.mypackage;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.e4.core.di.annotations.Creatable;

import com.mypackage.ISilencer;

@Creatable
public class BrowserSilencer {

    private static final Logger LOGGER = Logger.getLogger(BrowserSilencer.class);

    @Inject
    IExtensionRegistry exReg;

    public void silence=() {
        IConfigurationElement[] config = exReg.getConfigurationElementsFor("com.mypackage.silencer");
        try {
            for (IConfigurationElement e : config) {
                final Object o = e.createExecutableExtension("class");
                if (o instanceof ISilencer) {
                    executeExtension(o);
                }
            }
        } catch (CoreException ex) {
            LOGGER.error("Error finding the com.mypackage.silencer extension");
        }
    }

    private void executeExtension(final Object o) {
        ISafeRunnable runnable = new ISafeRunnable() {
            @Override
            public void handleException(Throwable e) {
                LOGGER.error("Exception while attempting to silence browser");
            }

            @Override
            public void run() throws Exception {
                ((ISilencer) o).silence();
            }
        };
        SafeRunner.run(runnable);
    }
}