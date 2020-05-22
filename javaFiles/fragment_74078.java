public boolean equals(Object o){
    if(o != null && (o instanceof Operation)) {
        List<Variable> oa = ((Operation)o).getArguments();
        Collections.sort(arguments);
        Collections.sort(oa);
        return ((Operation)o).getName().equals(name) &&
               ((Operation)o).getType().equals(type) &&
               ((Operation)o).getArguments().equals(arguments);
    }
    return false;
}