List<Bar> innerList = new ArrayList<Bar>();
// add Bar objects to this list
List<List<Bar>> mainList = new ArrayList<List<Bar>>();
mainList.add(innerList); // adding innerList to mainList
for(List<Bar> listElement:mainList){
     // here listElement will give you an innerList
         for(Bar bar: listElement){
            // gives you a handle to each Bar element stored in
            // listElement
         }
}