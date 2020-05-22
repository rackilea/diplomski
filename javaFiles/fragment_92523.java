private fun getOrderedItemsFromOneListToAnother(photosOrder: List<String>, 
                                                photosFound: List<Photo>): List<Photo>{
    val mapStringIdsOrder = photosOrder.mapIndexed { index, s ->  s to index}.toMap()

    Collections.sort(photosFound, Comparator { o1: Photo, o2: Photo->
        Integer.compare(mapStringIdsOrder.getOrDefault(o1.id,photosOrder.size), 
        mapStringIdsOrder.getOrDefault(o2.id, photosOrder.size))})

    return photosOrder
}