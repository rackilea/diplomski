String[] fontColor = new String[] {"Red", "Blue", "Green"};
 Color[] colorArr - new Color[] {"Color.RED","Color.BLUE","Color.GREEN"};

for (int i = 0; i < fontColors.length; i++) {
     JMenuItem fontC = new JMenuItem(fontColors[i]);
     fontC.addActionListener(new fontColorAction(colorArr [i));
     changeFontColor.add(fontC);
}