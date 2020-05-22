if (t.getSourceComponent() != doneTable && dropData.getTarget().equals(inProgressTable) ){
    ...
}else if(t.getSourceComponent() != doneTable && dropData.getTarget().equals(openTable)){
    ...
}else{
    return;
}