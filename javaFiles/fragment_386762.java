public class ArrayListDisease {

    public static List<String> process(List<String> input) {

        Map<String, Set<String>> map = new HashMap<String, Set<String>>();

        for(String s : input) {
            String [] nameAndDisease = s.split("\\.");
            if(map.containsKey(nameAndDisease[0])) {
                Set<String> diseases = map.get(nameAndDisease[0]);
                diseases.add(nameAndDisease[1]);
            }
            else {
                Set<String> set = new HashSet<String>();
                set.add(nameAndDisease[1]);
                map.put(nameAndDisease[0], set);
            }
        }

        List<String> res = new ArrayList<String>();
        for(Entry<String, Set<String>> e : map.entrySet()) {
            String key = e.getKey();
            Set<String> values = e.getValue();
            if(values.size() == 1) {
                res.add(key+"."+values.iterator().next());
            }
        }
        return res;
    }


    public static void main(String [] args) {
        List<String> input = new ArrayList<String>();
        input.add("Name: Aimee Cholmondeley. Disease: German measles");
        input.add("Name: Colin Anissina.     Disease: Diphtheria");
        input.add("Name: Colin Anissina.     Disease: Malaria");
        input.add("Name: Aimee Cholmondeley. Disease: Typhoid fever");
        input.add("Name: Isaias Cheung.      Disease: Haemophilus Influenza");
        input.add("Name: Isaias Cheung.      Disease: Scarlet fever");
        input.add("Name: Sebastian Cutting.  Disease: Gingivitis");
        input.add("Name: Juan Weiss.         Disease: Acquired Immunodeficiency Sydrome (AIDS)");
        input.add("Name: Kaelyn Nauman.      Disease: Amebiasis");
        input.add("Name: Kaelyn Nauman.      Disease: Human Pulmonary Syndrome (HPS)");
        input.add("Name: Lyndsey Stapleton.  Disease: Chlamydia");
        input.add("Name: Lyndsey Stapleton.  Disease: Chlamydia");

        System.out.println(process(input));
    }

}