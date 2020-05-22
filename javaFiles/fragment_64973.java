// build the composite
IComposite<IGraphic> myComposite = new Composite<IGraphic>(IGraphic.class);
myComposite.add(new Rectangle());                
myComposite.add(new Line());
myComposite.add(new Line());

// use the composite, invokes the IGraphic#draw() in the 
// underlying Rectangle and two Line instances
myComposite.getComponent().draw();