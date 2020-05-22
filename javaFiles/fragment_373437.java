while (!done) {
     if (menuBool) {
        if (menu.getChoice() != 0) {
           System.out.println("" + menu.getChoice());
           grid = new Grid(menu.getChoice());
           menu.resetChoice();
           frame.add(grid);
        }
     } else {
        if (grid.atEnd()) {
           frame.add(menu);
        }
     }
  }