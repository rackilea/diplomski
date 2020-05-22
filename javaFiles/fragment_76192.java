ArrayList<String> A_arraylist = new ArrayList<String>(Arrays.asList(a));
ArrayList<String> B_arraylist = new ArrayList<String>(Arrays.asList(b));

for (int i=0; i < A_arraylist.size(); i++){
     if(B_arraylist.contains(A_arraylist.get(i))){
          //do something for equals              
     }else{
          //do something for not equals
          int index = B_arraylist.indexOf(A_arraylist.get(i));
          B_arraylist.remove(index);
     }
}