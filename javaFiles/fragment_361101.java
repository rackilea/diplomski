AffineTransform t = new AffineTransform();
    t.translate(position.x, position.y);        
    t.rotate(object.getBody().getAngle());
    g.transform(t);
    g.fillRect((int)-(object.width), (int)-(object.height), (int)(object.width*2), (int)(object.height*2));
    try{
        g.transform(t.createInverse());
    }catch(NoninvertibleTransformException e){
        //...
    }