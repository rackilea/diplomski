public void launch() {
      int random = java.util.Random.nextInt(3);

      switch (random) {
        case 0:
            //from upside
            x_pos = rand.nextInt(Tanks.getSchermBreedte());
            y_pos =  0;
        break;
        case 1: 
          //leftside
          x_pos = 0;
          y_pos = rand.nextInt(Tanks.getSchermHoogte());
        break;
        case 2:
            //lower side
            x_pos = rand.nextInt(Tanks.getSchermBreedte());
            y_pos = Tanks.getSchermHoogte();
        break;
        case 3:
            //right
            x_pos = Tanks.getSchermBreedte();
            y_pos = rand.nextInt(Tanks.getSchermHoogte());
        break;
      }
}