private Map<GwtRole, CheckBox> mapping = new HashMap<>();

@Override
public void createBody() {
    for (GwtRole gwtRole : roleList) {
        CheckBox checkBox = new CheckBox();
        mapping.put(gwtRole, checkBox);
        // Your other code here.
    }
}

// Java 8
public List<GwtRole> getChecked()
{
    return mapping.entrySet().stream()
        .filter(e -> e.getValue().getValue())
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
}

// Pre-Java 8
public List<GwtRole> getChecked()
{
    List<GwtRole> result = new ArrayList<>();

    for(Map.Entry<GwtRole, CheckBox> e : map.entrySet())
    {
        if(e.getValue().getValue())
            result.add(e.getKey());
    }

    return result;
}