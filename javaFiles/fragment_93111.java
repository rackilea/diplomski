jMenu1.add(jMenuItem);
//jMenuItem.repaint();
//jMenuItem.revalidate();
MenuElement[] selectionPath = MenuSelectionManager.defaultManager().getSelectedPath();
MenuSelectionManager.defaultManager().clearSelectedPath();
MenuSelectionManager.defaultManager().setSelectedPath(selectionPath);