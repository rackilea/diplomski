final VerticalLayout screen = new VerticalLayout();
...
final VerticalLayout top = new VerticalLayout();
...
final VerticalLayout bot = new VerticalLayout();
...

// Set expand ratios
screen.setExpandRatio(top, 3);
screen.setExpandRatio(bot, 7);