package com.mypackage.core.src;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class UnderDirectoryReloadableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {

    @Autowired
    ServletContext servletContext;

    public void setWorkingDirectory(String directoryPath) {
        File rootDir = new File( servletContext.getRealPath(directoryPath) );
        ArrayList<String> baseNames = new ArrayList<String>();
        iterateScanDirectoryAndAddBaseNames(baseNames, rootDir);
        setBasenames(baseNames.toArray(new String[baseNames.size()]));
    }

    private void iterateScanDirectoryAndAddBaseNames(ArrayList<String> baseNames, File directory) {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                iterateScanDirectoryAndAddBaseNames(baseNames, file);
            } else {
                if (file.getName().endsWith(".properties")) {
                    String filePath = file.getAbsolutePath().replaceAll("\\\\", "/").replaceAll(".properties$", "");
                    filePath = filePath.substring(filePath.indexOf("/WEB-INF/"), filePath.length());
                    baseNames.add(filePath);
                    System.out.println("Added file to baseNames: " + filePath);
                }
            }
        }
    }

}