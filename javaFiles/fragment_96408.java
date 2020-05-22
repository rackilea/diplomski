private List<ResponseObject> sortInOrder(List<ResponseObject> responseList,List<Long> orderedIdList) {
    List<ResponseObject> finalList = new ArrayList<>();
    Map<Long, ResponseObject> map = responseList.stream().collect(Collectors.toMap(ResponseObject::getId, respObj -> respObj));
    for(Long id : orderedList) {
      if(map.containsKey(id)) {
         finalList.add(map.get(id));
      }
    }
    return finalList;
}