if( visited.get(e.destination()) == null || visited.get(e.destination()) == false )
{
    visited.putIfAbsent(e.destination(), true);
    path.putIfAbsent(e.destination(), e);
    queue.add(e.destination());
}