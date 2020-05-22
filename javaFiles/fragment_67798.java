public boolean Insert(PLoc p){
    boolean found = false;
    Iterator<Map.Entry<String, TreeSet<PLoc>>> iterator = tm.entrySet().iterator();
    TreeSet<PLoc> aux;
    while (iterator.hasNext() && !found) {
        Map.Entry<String, TreeSet<PLoc>> mentry = iterator.next();
        if(mentry.getKey().equalsIgnoreCase(p.getPais())) {
            found = true;
            aux = mentry.getValue();
        }
    }
}