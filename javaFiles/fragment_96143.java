public List<Capital> autocomplete(Object suggest) {
    String pref = (String)suggest;
    ArrayList<Capital> result = new ArrayList<Capital>();

    Iterator<Capital> iterator = getCapitals().iterator();
    while (iterator.hasNext()) {
        Capital elem = ((Capital) iterator.next());
        if ((elem.getName() != null && elem.getName().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref))
        {
            result.add(elem);
        }
    }
    return result;
}