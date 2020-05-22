List<List<String>> yourCategoryList = null;
if((yourCategoryList = categories.get(category)) == null){
    yourCategoryList = new ArrayList<>();
    categories.put(category, yourCategoryList );
 }    
yourCategoryList.add(product);