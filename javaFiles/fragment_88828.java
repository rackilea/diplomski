public class CityReader {
    public static void main(String[] args) throws InvalidFileFormatException, IOException {
        File file = new File("src/main/resources/widget.ini");
        Ini ini = new Ini(file);

        Map<String, String> mapkey = new HashMap<String, String>();

        List<String> key = new ArrayList<String>();
        key.add("CT");
        key.add("JO");

        for (String s : key) {
            for (String sectionName: ini.keySet()) {
                Section section = ini.get(sectionName);
                for (String optionKey: section.keySet()) {
                    if(section.get(optionKey).equals(s))
                        mapkey.put(optionKey, section.get(optionKey));
                }
            }
        }
        System.out.println(mapkey);
    }
}