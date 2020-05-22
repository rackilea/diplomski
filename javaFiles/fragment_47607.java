public void clearGraph( Graph graph )
{       
    Object[] objects = graph.getConnections().toArray() ;           
    for (int i = 0 ; i < objects.length; i++)
    {
        GraphConnection graCon = (GraphConnection) objects[i];
        if(!graCon.isDisposed())
            graCon.dispose();
    }            

    objects = graph.getNodes().toArray();       
    for (int i = 0; i < objects.length; i++)
    {
        GraphNode graNode = (GraphNode) objects[i];
        if(!graNode.isDisposed())
            graNode.dispose();
    }
}