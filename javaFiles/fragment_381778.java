val result = sequence {
    val first = list1.iterator()
    val second = list2.iterator()
    while (first.hasNext() && second.hasNext()) {
      yield(first.next())
      yield(second.next())
    }

    yieldAll(first)
    yieldAll(second)
  }.toList()