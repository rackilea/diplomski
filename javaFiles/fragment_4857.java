val (_, lastList, otherLists) = map.foldLeft(0L, List[String](), List[List[String]]()) {
  case ((soFar, newList, oldLists), (path, size)) =>
    if (soFar + size > limit)
      (size, List(path), newList :: oldLists)
    else
      (soFar + size, path :: newList, oldLists)
}
lastList :: otherLists