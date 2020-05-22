for(Category catList:listCategory){
    for(Category cat:selectedCategorysSet){
        if(cat.getCategoryId() == catList.getCategoryId()){
            tmpList.add(catList);
        }
    }
}

listCategory.removeAll(tmpList);