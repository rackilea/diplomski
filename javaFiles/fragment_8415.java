public void addRecord(Record a){
    records.put(a.getId(), a);
    history.commit("user", a);
}
public void removeRecord(Record a){
    records.remove(a.getId());
    history.commitShallowDelete("user", a);
}
public void updateRecord(Record a){
    records.put(a.getId(), a);
    history.commit("user", a); 
}