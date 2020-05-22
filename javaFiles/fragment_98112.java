double rotation = Math.toDegrees(Math.atan2(currentPlanet.pos[1]-currentPlayer.pos[1], currentPlanet.pos[0]-currentPlayer.pos[0]));
double diff =  ((rotation-currentPlayer.rotation)%360.0+360.0+180.0)%360.0-180.0;   

if(diff>0)
    turn right
else
    turn left