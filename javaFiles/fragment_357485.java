if(Greenfoot.isKeyDown("x")){

      if(speed<10 && !adjustedSpeed) speed++;
      adjustedSpeed = true;

    } else if(Greenfoot.isKeyDown("y")){

      if(speed>0 && !adjustedSpeed) speed--;
      adjustedSpeed = true;

    } else {

      adjustedSpeed = false

    }