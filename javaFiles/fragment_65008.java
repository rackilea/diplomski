private LinkedHashSet<String> items = new LinkedHashSet<String>();
public Collection<String> getItems(){
    return Collections.unmodifiableSet(items);
}
public void addItem(String s){
    items.add(s);
}