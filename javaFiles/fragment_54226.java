public void execute() {  
    Iterator iter = objects.iterator();  
    Shape shape;  
    while(iter.hasNext()){  
        shape = (Shape)iter.next();  
        mt.addMememto(shape);  
        AffineTransform t = new AffineTransform();
        System.out.println("Translation x :"+x + ", Translation y :"+y);
        t.translate(x,y);
        t.concatenate(shape.getAffineTransform());
        shape.setAffineTransform(t);  
    }  
}