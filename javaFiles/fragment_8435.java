while(iter.hasNext()){
        shape = (Shape)iter.next();                     
        AffineTransform t = new AffineTransform();
        t.scale(sx,sy); 
        t.concatenate(shape.getAffineTransform());
        shape.setAffineTransform(t); 
    }
}