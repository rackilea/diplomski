categoryList = musicList.stream()
              .map((music)-> music.category)
              .distinct()
              .collect(Collectors.toCollection(ArrayList::new));

Log.d("CATEGORY LIST" ,  categoryList.toString())

//LOG Output 
CATEGORY LIST: [category1, category2, category3, category4]