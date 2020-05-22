for(int i = 0; i <= nAstroAnimPos + 1; i++){
    if(i == 0 || i == nAstroAnimPos + 1) // Start and end with stand position
        g2d.drawImage(imgAstroStandLeft, nAstronautX + 1, nAstronautY + 1, this);
    else // Run the sequence from 1 to 6
        g2d.drawImage(arimgAstroWalkLeft[i], nAstronautX + 1, nAstronautY + 1, this);    
}