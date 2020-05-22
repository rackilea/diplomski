ArrayList<Foo> list1 = new ArrayList<Foo>();
ArrayList<Bar> list2 = new ArrayList<Bar>();

final HashMap<String, Integer> positions = new HashMap<String, Integer>();
for(int i=0;i<list1.size();i++){
    positions.put(obj.getString(), i);
}

Collections.sort(list2, new Comparator<Bar>(){
    public int compare(Bar obj1, Bar obj2){
        return positions.get(obj2.getString()) - positions.get(obj1.getString());
    }
});