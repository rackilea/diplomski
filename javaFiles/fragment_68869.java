@Property
private Object currentKey;

@Persist
private Set<String> selection = new HashSet<String>();

public Map<String,String> getMyMap() {
    ...
}

public boolean getCurrentValue() {
     return this.selection.contains(this.currentKey);
}

public void setCurrentValue(final boolean currentValue) {
    final String mapValue = this.getMapValue();

    if (currentValue) {
        this.selection.add(mapValue);
    } else {
        this.selection.remove(mapValue);
    }
}


public String getMapValue() {
    return this.getMyMap().get(this.currentKey);
}