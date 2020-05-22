URL resource = logaff.class.getResource(IMAGE);
Icon icon = new ImageIcon(resource);

UIManager.put("Tree.closedIcon", icon);
UIManager.put("Tree.openIcon", icon);
UIManager.put("Tree.leafIcon", icon);