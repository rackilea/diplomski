package de.scrum_master.app;

import com.profesorfalken.wmi4java.WMI4Java;
import com.profesorfalken.wmi4java.WMIClass;

import java.util.Arrays;

public class Printer {
    public static void main(String[] args) {
        System.out.println(
            WMI4Java
                .get()
                .properties(Arrays.asList("Name", "WorkOffline"))
                .getRawWMIObjectOutput(WMIClass.WIN32_PRINTER)
        );
    }
}