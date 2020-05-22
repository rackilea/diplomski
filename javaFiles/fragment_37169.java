removeElements(element) {

tempEdge = graph.getOutgoingEdgeFrom(element)
if(tempEdge !=null)
   return;
tempVertex = graph.getTargetVertex(tempEdge)
removeElements(tempVertex)
graph.remove(tempVertex)

}