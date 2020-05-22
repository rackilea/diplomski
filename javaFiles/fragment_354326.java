public List<> filterList(List<> listToBeFiltered){
    List<> filteredList = listToBeFiltered.parallelStream()
        .filter(/* some inverted filtering logic */)
        .collect(Collectors.toList());
    listToBeFiltered.clear();
    listToBeFiltered.addAll(filteredList);
    return listToBeFiltered;
}