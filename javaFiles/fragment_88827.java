import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;

public class CityReader {
    public static void main(String[] args) throws InvalidFileFormatException, IOException {
        Map<String, String> mapCT = new HashMap<String, String>();
        Map<String, String> mapJO = new HashMap<String, String>();

        File file = new File("src/main/resources/widget.ini");
        Ini ini = new Ini(file);
        for (String sectionName: ini.keySet()) {
            Section section = ini.get(sectionName);
            for (String optionKey: section.keySet()) {
                if(section.get(optionKey).equals("CT"))
                    mapCT.put(optionKey, section.get(optionKey));
                if(section.get(optionKey).equals("JO"))
                    mapJO.put(optionKey, section.get(optionKey));
            }
        }
        System.out.println(mapCT);
        System.out.println(mapJO);
    }
}