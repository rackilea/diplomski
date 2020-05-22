xlist.add(x); 
im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right");

am = this.getActionMap();
am.put("right", ka);

// **** the comment below is incorrect ****
//only prints out zero - should print out ascending values of x as I hold down the right arrow key
System.out.println(ka.getNextX(xlist));