Panel container = new Panel();
container.setLayout(new GridLayout(1,0));
container.add(secondApplet); //Display Applet
add(container):

secondApplet.init();
secondApplet.start();

button.setVisible(false);