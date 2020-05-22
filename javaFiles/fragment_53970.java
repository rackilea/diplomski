Box radioButtons = Box.createHorizontalBox();
radioButtons.add(paint);
radioButtons.add(select);

Box panels = Box.createHorizontalBox();
panels.add(prototype_panel);
panels.add(selection_panel);

Box windowContents = Box.createVerticalBox();
windowContents.add(radioButtons);
windowContents.add(panels);

setLayout(new BorderLayout());
add(windowContents);