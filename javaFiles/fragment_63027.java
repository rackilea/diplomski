public void paint(Graphics g){
    Graphics2D g2D = (Graphics2D)g;
    for(Element element : theApp.getModel()){
        element = (Element)elements.iterator().next();
        g2D.setPaint(element.getColor());
        g2D.draw(element.getShape());
    } 
}