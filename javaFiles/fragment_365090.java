private void init()
{
    frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    frame.setSize(Settings.getX(), Settings.getY());
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    for (int i = 0; i < y ; i++)
    {
        for (int j = 0; j < x; j++)
        {
            for (int k = 0; k < tilesetsOnCharactersSize; k++)
            {
                tilesetsOnCharacters[i][j][k] = new javax.swing.JLabel(new javax.swing.ImageIcon(Resources.getTileset(Maps.getMapTileset(mapNumber, 1, k, i, j))));
                tilesetsOnCharacters[i][j][k].setBounds(j * tilesetX, i * tilesetY, tilesetX, tilesetY);
                map.add(tilesetsOnCharacters[i][j][k], 4);
            }
            for (int k = 0; k < tilesetsUnderCharactersSize; k++)
            {
                tilesetsUnderCharacters[i][j][k] = new javax.swing.JLabel(new javax.swing.ImageIcon(Resources.getTileset(Maps.getMapTileset(mapNumber, 0, k, i, j))));
                tilesetsUnderCharacters[i][j][k].setBounds(j * tilesetX, i * tilesetY, tilesetX, tilesetY);
                map.add(tilesetsUnderCharacters[i][j][k], 0);
            }
            for (int k = 0; k < mapAttributeSize; k++)
            {
                if (Maps.getMapTileset(mapNumber, 2, k, i, j) == 1)
                {
                    blocked[i][j] = true;
                }
            }
        }
    }
    for (int i = 0; i < charactersNumber; i++)
    {
        characters[i] = new Character(0, 0, 64, 64, 0, 0, 0, 0, 5);
        tilesetsCharacters[i] = new javax.swing.JLabel(new javax.swing.ImageIcon(Characters.getCharacter(characters[i].getCharacterSkin(), characters[i].getDirection())));
        tilesetsCharacters[i].setBounds(characters[i].getX(), characters[i].getY(), characters[i].getSizeX(), characters[i].getSizeY());
        map.add(tilesetsCharacters[i], 1);
        charactersRender[i] = false;
    }

    frame.addKeyListener(new java.awt.event.KeyAdapter()
    {
        @Override
        public void keyTyped(java.awt.event.KeyEvent keyEvent)
        {

        }

        @Override
        public void keyPressed(java.awt.event.KeyEvent keyEvent)
        {
            if((keyEventInt = keyEvent.getKeyCode()) == java.awt.event.KeyEvent.VK_F)
            {
                right = true;
            }
            else if(keyEventInt == java.awt.event.KeyEvent.VK_S)
            {
                left = true;
            }
            else if(keyEventInt == java.awt.event.KeyEvent.VK_E)
            {
                up = true;
            }
            else if(keyEventInt == java.awt.event.KeyEvent.VK_D)
            {
                down = true;
            }
        }

        @Override
        public void keyReleased(java.awt.event.KeyEvent keyEvent)
        {
            if((keyEventInt = keyEvent.getKeyCode()) == java.awt.event.KeyEvent.VK_F)
            {
                right = false;
            }
            else if(keyEventInt == java.awt.event.KeyEvent.VK_S)
            {
                left = false;
            }
            else if(keyEventInt == java.awt.event.KeyEvent.VK_E)
            {
                up = false;
            }
            else if(keyEventInt == java.awt.event.KeyEvent.VK_D)
            {
                down = false;
            }
        }
    });

    frame.setContentPane(map);
    frame.setVisible(true);
}

private void update()
{
    if (exit && characters[0].getX() < x * tilesetX - characters[0].getSizeX() - characters[0].getMovementSpeed() && characters[0].getX() > 0 && characters[0].getY() > 0 && characters[0].getY() < y * tilesetY - characters[0].getSizeY() - characters[0].getMovementSpeed())
    {
        exit = false;
    }
    if (right && (exit || (characters[0].getX() < x * tilesetX - characters[0].getSizeX() - characters[0].getMovementSpeed() && !blocked[characters[0].getY() / tilesetY][(characters[0].getX() + characters[0].getSizeX() + characters[0].getMovementSpeed()) / tilesetX] && !blocked[(characters[0].getY() + characters[0].getSizeY()) / tilesetY][(characters[0].getX() + characters[0].getSizeX() + characters[0].getMovementSpeed()) / tilesetX])))
    {
        characters[0].right();
        characters[0].setScaleX(5);
        if (allowExitRight && characters[0].getX() > x * tilesetX - characters[0].getSizeX() - characters[0].getMovementSpeed() - 1)
            exit = true;
        charactersRender[0] = true;
    }
    if (left && (exit || (characters[0].getX() > 0 && !blocked[characters[0].getY() / tilesetY][(characters[0].getX() - characters[0].getMovementSpeed()) / tilesetX] && !blocked[(characters[0].getY() + characters[0].getSizeY()) / tilesetY][(characters[0].getX() - characters[0].getMovementSpeed()) / tilesetX])))
    {
        characters[0].left();
        characters[0].setScaleX(-3);
        if (allowExitLeft && characters[0].getX() <= 0)
            exit = true;
        charactersRender[0] = true;
    }
    if (jumped || up && (exit || (characters[0].getY() > 0 && !blocked[(characters[0].getY() - characters[0].getMovementSpeed()) / tilesetY][characters[0].getX() / tilesetX] && !blocked[(characters[0].getY() - characters[0].getMovementSpeed()) / tilesetY][(characters[0].getX() + characters[0].getSizeX()) / tilesetX])))
    {
        if (!jump)
        {
            characters[0].up();
            characters[0].setScaleY(-3);
            if (allowExitUp && characters[0].getY() <= 0)
                exit = true;
            charactersRender[0] = true;
        }
        else if (!jumped && !falling)
        {
            jumpCurrentDuration = jumpDuration;
            jumped = true;
        }
        else if (--jumpCurrentDuration > 0)
        {
            if (exit || (characters[0].getY() > 0 && !blocked[(characters[0].getY() - characters[0].getMovementSpeed()) / tilesetY][characters[0].getX() / tilesetX] && !blocked[(characters[0].getY() - characters[0].getMovementSpeed()) / tilesetY][(characters[0].getX() + characters[0].getSizeX()) / tilesetX]))
            {
                characters[0].up();
                characters[0].setScaleY(-3);
                if (allowExitUp && characters[0].getY() <= 0)
                    exit = true;
                charactersRender[0] = true;
            }
        }
        else
        {
            jumped = false;
        }
    }
    if (((down && !jumped) || (gravity && !jumped)) && (exit || (characters[0].getY() < y * tilesetY - characters[0].getSizeY() - characters[0].getMovementSpeed() && !blocked[(characters[0].getY() + characters[0].getSizeY() + characters[0].getMovementSpeed()) / tilesetX][characters[0].getX() / tilesetX] && !blocked[(characters[0].getY() + characters[0].getSizeY() + characters[0].getMovementSpeed()) / tilesetY][(characters[0].getX() + characters[0].getSizeX()) / tilesetX])))
    {
        characters[0].down();
        characters[0].setScaleY(5);
        if (allowExitDown && characters[0].getY() > y * tilesetY - characters[0].getSizeY() - characters[0].getMovementSpeed())
            exit = true;
        if (jump)
            falling = true;
        charactersRender[0] = true;
    }
    else if (jump)
        falling = false;
}

private void render()
{
    for (int i = 0; i < charactersNumber; i++)
    {
        if (charactersRender[i])
        {
            tilesetsCharacters[i].setIcon(new javax.swing.ImageIcon(Characters.getCharacter(characters[i].getCharacterSkin(), characters[i].getDirection())));
            tilesetsCharacters[i].setBounds(characters[i].getX() + characters[i].getScaleX(), characters[i].getY() + characters[i].getScaleY(), characters[i].getSizeX(), characters[i].getSizeY());
            charactersRender[i] = false;
        }
    }
}