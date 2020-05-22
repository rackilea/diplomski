package com.nahrot.teleportball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class MyInputProcessor implements InputProcessor
{
    public Vector2 leftTouchPos = new Vector2();
    public Vector2 rightTouchPos = new Vector2();
    public boolean touchLeft = false;
    public boolean touchRight = false;

    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        if(sideTouched(screenX, true))
    { 
            touchLeft = true;
            leftTouchPos.set(screenX, screenY);
    }
    if(sideTouched(screenX, false))
    {
        touchRight = true;
        rightTouchPos.set(screenX, screenY);
    }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        if(sideTouched(screenX, true))
        { 
            touchLeft = false;
    }
    if(sideTouched(screenX, false))
    {
        touchRight = false;
    }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }

    private boolean sideTouched(int x, boolean checkLeft)
    {
    if(checkLeft)
    {
        if(x <= Gdx.graphics.getWidth() / 2)
            return true;
    }
    else
    {
        if(x > Gdx.graphics.getWidth() /2)
            return true;
    }
    return false;
    }
}