//the listener class
    Array<Vector2> lineDraws = new Array<Vector2>();

    ...

    //touchDown class
    lineDraws.add(new Vector2(screenX, screenY));

    projector.unproject( new Vector2(startX, startY) );

    //consider adding some flag here to prevent two pointers touch (when holding finger, touching with another)

    //touchUp
    projector.unproject( new Vector2(screenX, screenY) );
    lineDraws.add(new Vector2(screenX, screenY));

    ...

    //the screen class render method
    for(int i = 0; i < listener.lineDraws.size - 1; i+=2)
    {
        renderer.line(listener.lineDraws.get(i), listener.lineDraws.get(i + 1));

}