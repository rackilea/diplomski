list.add(status);
list.add("Q");
list.add("P");
list.add("F");
list.add("I");
list.add("C");
int position = -1;
    for(i=0;i<list.size();i++){
        if(list.get(i).equals(status)) {
                position = i;
        }
   }
if(position>0)
   list.removeAt(position);