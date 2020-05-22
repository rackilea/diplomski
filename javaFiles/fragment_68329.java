if (player == true) {
        p = polelode1; 
     }
  else {
        p = polelode2;
    }
    if((p[x][y] || p[x][y + 1] || p[x][y + 2] || p[x - 1][y + 1] || p[x - 1][y + 2] || p[x][y + 3])!= true){ 
        p[x][y] = true;
        p[x][y + 1] = true;
        p[x][y + 2] = true;
        p[x - 1][y + 1] = true;
        p[x - 1][y + 2] = true;
        p[x][y + 3] = true;
    }