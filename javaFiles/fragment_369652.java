// using some groovy for simplicity note that this is graph query syntax 
// and not a "pipeline". to convert to java, you will just need to iterate
// the result of vertices() into an ArrayList and convert the use of 
// each{} to foreach or some other java construct 
mgr100 = g.query().has("mgrNo",CONTAINS_PREFIX,"100").vertices().toList()
mgr200 = g.query().has("mgrNo",CONTAINS_PREFIX,"200").vertices().toList()

mgr100.each {
    mgr200.findAll{x -> x.location == it.location}.each{x -> it.addEdge('near', x)}
}