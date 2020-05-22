musicList.forEach((music) -> {
    categoryList.add(music.category);
});

LinkedHashSet<String> uniqueCategoryHashSet = new LinkedHashSet(categoryList);

categoryList.clear();
categoryList.addAll(uniqueCategoryHashSet);

Log.d("CATEGORY LIST" ,  categoryList.toString())

//LOG Output 
CATEGORY LIST: [category1, category2, category3, category4]