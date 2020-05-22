Map data = [:]
result?.data?.eachWithIndex { dataItem, idx ->
   if (dataItem) {
      log.info dataItem
      data[idx] = dataItem
   }
}