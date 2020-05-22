for(int across = player.PlayerX-5; across < player.PlayerX+5; across++) 
{
  for(int vert = player.PlayerY-5; vert < player.PlayerX+5; vert++)
  {
    //double RANDOM = Math.random();
    if(across < 0 || vert < 0)  //might want to check the 'high' bounds here too
    {
    }
    else if(levONE.A[vert][across] == 1)
    {
      g.drawImage(Floor,across*32,vert*32,this);
    }
    else if(levONE.A[vert][across] == 0) 
    {
      g.drawImage(Wall,across*32,vert*32,this);
    }

    //print ("%d ", levONE.A[vert][across]);
  }
  //print ("\n");
}