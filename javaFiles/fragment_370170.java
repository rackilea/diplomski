package de.scrum_master.app;

import com.profesorfalken.wmi4java.WMI4Java;
import com.profesorfalken.wmi4java.WMIClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Printer {
    public static void main(String[] args) {
        String rawOutput = WMI4Java
            .get()
            .properties(Arrays.asList("Name", "WorkOffline"))
            .filters(Arrays.asList("$_.WorkOffline -eq 0"))
            .getRawWMIObjectOutput(WMIClass.WIN32_PRINTER);
        List<String> printers = Arrays.stream(rawOutput.split("(\r?\n)"))
            .filter(line -> line.startsWith("Name"))
            .map(line -> line.replaceFirst(".* : ", ""))
            .sorted()
            .collect(Collectors.toList());
        System.out.println(printers);
    }
}