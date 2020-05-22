static List<String> list;
static Map<String, String> map = new HashMap<>();

/**
 * Launch the application.
 */
public static void main(String[] args) {
    add("Aa");
    add("Bb");
    add("CC");

    //should return Aa
    String originalValue = getOriginalElement("aa");

    //should return Bb
    originalValue = getOriginalElement("BB");

    //should return CC
    originalValue = getOriginalElement("cc");
}

static public void add(String element){
    list.add(element);
    map.put(element.toLowerCase(), element);
}

static public String getOriginalElement(String caseInsensitiveStr){
    return map.get(caseInsensitiveStr.toLowerCase());
}