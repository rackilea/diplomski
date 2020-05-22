JTabbedPane outer = new JTabbedPane();
outer.setOpaque(false);
// ...
// creating inner pane "Modificar"
JTabbedPane modificar = new JTabbedPane();
modificar.setOpaque(false);
outer.addTab("Modificar", modificar);