@Override
public int hashCode() {
    return getName().hashCode();
}


@Override
public boolean equals(Object o) {
    if(o == null){
        return false;
    }
    if(!o.getClass().equals(getClass())){
        return false;
    }
    return this.getName().equals(((Item)o).getName());
}