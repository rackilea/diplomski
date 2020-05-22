package com.me.mygdxgame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class HandScreen implements Screen{
    SpriteBatch batch = new SpriteBatch();
    OrthographicCamera camera;
    TextureRegion handRegion;
    Texture handTexture;
    Vector3 touchPoint = new Vector3(0,0,0);
    double rotation = 0;
    float width,height;
    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
        if (Gdx.input.isTouched()) {
             camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(),0));

             // the center of your hand
             Vector3 center = new Vector3(width/2,height/2,0);
             // you need a vector from the center to your touchpoint
             touchPoint.sub(center); 
             // now convert into polar angle                             
             rotation = Math.atan2(touchPoint.y, touchPoint.x);
             // rotation should now be between -PI and PI
             // so scale to 0..1
             rotation = (rotation + Math.PI)/(Math.PI * 2); 
             // SpriteBatch.draw needs degrees
             rotation *= 360;
             // add Offset because of reasons
             rotation += 90;
        }


        batch.begin();
        batch.draw(handRegion, 
                width/2, // x, center of rotation
                height/2, //y, center of rotation
                0, // origin x in the texture region
                0,// origin y in the texture region
                10, // width
                100, // height
                1, // scale x
                1,// scale y
                (float)rotation); // rotation !          
        batch.end();
     } 


    @Override
    public void show() {
        handTexture = new Texture(Gdx.files.internal("img/coin.png"));
        handRegion = new TextureRegion(handTexture);
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();       
        camera.viewportHeight = height;
        camera.viewportWidth = width;
        camera.position.set(camera.viewportWidth * .5f, camera.viewportHeight * .5f, 0f);  
        camera.update(); 

    }
    // rest of screen interface
    @Override
    public void hide() {


    }

    @Override
    public void pause() {


    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {


    }
    @Override
    public void resize(int width, int height) {


    }

}