Body body, planet; //your 'character' and planet

    ...

    Vector2 bodyCenter = body.getWorldCenter();
    Vector2 planetCenter = planet.getWorldCenter(); //if you would use getPosition it would be related to the body's origin!

    Vector2 subVector = bodyCenter.sub( planetCenter );

    body.setTransform(x, y, subVector.angle() ); //it is possible that you will need to make '-angle()' here or something!