List<String> employeNameList=new PartialNameList<>(nameList);
List<Employe> filteredList=new ArrayList<>();
for(Employe e: employeList){
   if(employeNameList.contains(e.getName()){
    filteredList.add(e);
   }
}