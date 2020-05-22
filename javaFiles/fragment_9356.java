private fun createItems(objects: List<Someobjects>): Mono<Array<ProcessedObject> {
         return Flux.fromIterable(objects)
           .concatMap {
             processObject(it)
           }.collectList().map { it.toTypedArray() }
}