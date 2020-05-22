public void render(Graphics g){
    List<ElementType> elements = new ArrayList<>();
    elements.add(player);
    elements.add(title);
    ...

    //sort the list such that elements with higher y-value at lower indices than elements
    //with lower y-value
    Collections.sort(elements , (a , b) -> Integer.compare(b.getY() - a.getY());

    for(ElementType element : elements)
        element.render(g);
}