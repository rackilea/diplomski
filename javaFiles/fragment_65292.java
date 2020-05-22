private void moveGhosts(Graphics2D g2d) {
    // Utilize an enhanced for loop
    for(Ghost ghost : ghosts){
        ...
        ...
        ghostx[i] = ghostx[i] + (ghostdx[i] * ghostspeed[i]);
        ghosty[i] = ghosty[i] + (ghostdy[i] * ghostspeed[i]);
        drawGhost(g2d, ghost);

        if (pacmanx > (ghostx[i] - 12) && pacmanx < (ghostx[i] + 12)
        ...
        ...
    }
}