for (Object o1 : list) {
    List<Object> subList = list.subList(list.indexOf(o1) + 1, list.size());
    for (Object o2 : subList) {
         //Do something with o1 and o2
    }
}