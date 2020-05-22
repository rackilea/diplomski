for(MasterList attributeMaster: typeOfRepositoryMasterList){
    boolean found = false;
    for(biobankList attribute: typeOfRepositoryBiobankList){
        if(attributeMaster.getListValue().equals(attribute.getListValue())){
            System.out.println("equal");
            selectedList.add(new KeyValuePair(attribute.getListName()+"_"+attribute.getListValue(), attribute.getListValue()));
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("not equal");
        availableList.add(new KeyValuePair(attributeMaster.getListName()+"_"+attributeMaster.getListValue(),attributeMaster.getListValue()));

    }  
}