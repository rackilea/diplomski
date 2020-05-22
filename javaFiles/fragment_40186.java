import java.util.*;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MapAdapter extends XmlAdapter<MapAdapter.MapElements, Map<String, String>> {

    @Override
    public MapElements marshal(Map<String, String> stringStringMap) throws Exception {
        MapElements mapElements = new MapElements();
        for (Map.Entry<String, String> entry: stringStringMap.entrySet()) {
            mapElements.item.add(new MapElement(entry.getKey(), entry.getValue()));
        }
        return mapElements;
    }

    @Override
    public Map<String, String> unmarshal(MapElements mapElements) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        for (MapElement mapElement : mapElements.item) {
            map.put(mapElement.key, mapElement.value);
        }
        return map;
    }

    public static class MapElements {
        public List<MapElement> item = new ArrayList<MapElement>();
    }

    public static class MapElement {
        public String key;
        public String value;

        public MapElement() {
        }

        public MapElement(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }

}