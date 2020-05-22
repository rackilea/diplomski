package com.me.mygdxgame;


import com.badlogic.gdx.Version;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public final static String VERSION= "0.0.1";

    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "my-gdx-pong-game";
        cfg.resizable= false;
        cfg.width = 480;
        cfg.height = 320;

        new LwjglApplication(new MyGdxGame(), cfg);
    }
}