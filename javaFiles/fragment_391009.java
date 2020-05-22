visited = {}
function visit(node) {
  if node in visited {
    doStuffOnReoccurence(node)
    return
  }
  visited.add(node)
  doStuffBeforeOthers(node)
  for each otherNode in node.expand() visit(otherNode)
  doStuffAfterOthers(node)
}