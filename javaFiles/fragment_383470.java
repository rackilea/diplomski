Container conProducts = new Container(new BorderLayout());
    Container conBorder = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    conProducts.setScrollableY(true);

    ...

    conBorder.add(mbProducts);
    conProducts.add(BorderLayout.CENTER, conBorder);