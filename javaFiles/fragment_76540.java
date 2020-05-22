package com.adsiz.areyoualive.screen;

import com.adsiz.areyoualive.game.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class PlayScreen implements Screen, InputProcessor{
    public ScreenManager screenManager;
    public static float speed = 32;

    //tilemap & camera
    TiledMap tiledMap;
    OrthographicCamera camera;
    OrthogonalTiledMapRenderer renderer;
    //player
    Player player;

    public PlayScreen(){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();

        tiledMap = new TmxMapLoader().load("map/untitled.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);

        camera.position.set(0, 3200, 0);

        Gdx.input.setInputProcessor(this);
        player = new Player(0, 3200);
    }

    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        camera.update();
        renderer.setView(camera);
        renderer.render();

        renderer.getSpriteBatch().begin();
        player.draw(renderer.getSpriteBatch());
        renderer.getSpriteBatch().end();

    }