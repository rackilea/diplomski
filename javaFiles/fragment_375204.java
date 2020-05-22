level.material=array of points from the level
         w=width of hitbox
         h=height of hitbox
         x=upper left x
         y=upper left y
         onground=false;
         double maxy=1000;

         for (Point p:level.material) {
              if (p.x >= (int)x && p.x <= (int)x+w) { //Is the player over the point ? (is the point between player x and player x+w)
                      if (p.y >= (int)(y+h) && (int)(y+h+yvel) >= p.y && p.y-h-1 < maxy) { //Would he go through a platform if the yvel would be added ? And is this the earliest point where this happens ?
                          maxy=p.y-p2.y-1d; //Set new earliest point
                          onground=true; //He is onground
                      }
                  }
              }
         }

         if (onground==true) {
             y=maxy; //Dont fall through the floor ! Stop at the earliest point !
             yvel=0; //There isnt any velocity downwards anymore.
             xvel=xvel-xvel/4; //Friction
         }