List<Pojo> originalList.... //your list of POJOs  
List<List<Pojo>> pojoList = new ArrayList<List<Pojo>>(originalList/10 + 1);  
for(int i = 0; i < originalList.size(); i+=10){  
    if(i + 10 > originalList.size()){  
         pojoList.add(originalList.subList(i, originalList.size()));
    }
    else{
         pojoList.add(originalList.subList(i, i + 10));  
    }  
}