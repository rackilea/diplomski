while (prevYPos < gameMap.length) { //this if while checks that Hek's position isn't located within the last column of the map and then
            hek.setPosition(prevXPos, prevYPos - 1); //moves him into the position that is directly right.
            int newX = hek.getXPosition();
            int newY = hek.getYPosition();
            this.addHek(hek, newX, newY);
            moveMade = true;
    }