// GameObject.h

class GameObject
{
public:
    virtual void update() = 0;
    virtual void paint(Graphics g) = 0;
    virtual ~GameObject() {}
}

// Player.h
#include "GameObject.h"

class Player: public GameObject
{
public:
    void update();

    void paint(Graphics g);
}

// Player.cpp
#include "Player.h"

void Player::update()
{
     // ...
}

void Player::paint(Graphics g)
{
     // ...
}