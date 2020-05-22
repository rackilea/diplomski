void DFS(Vertex v) {
  if (v.hasVisited)
    return;
  v.hasVisited = true;
  doBeforeDepth(v)
  for (Vertex u : v.neighbours)
    DFS(u);
  doAfterDepth(v);
}

void DFS()
{
    for (Vertex v : vertices)
        DFS(v);
}