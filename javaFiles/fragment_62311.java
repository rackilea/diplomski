package com.ziesemer.test;

import java.net.URL;

import javax.media.Manager;
import javax.media.Player;
import javax.media.bean.playerbean.MediaPlayer;

/**
 * @author Mark A. Ziesemer
 *  <a href="http://www.ziesemer.com.">&lt;www.ziesemer.com&gt;</a>
 */
public class JmfTest{
    public static void main(String[] args) throws Exception{
        URL url = JmfTest.class.getResource("Test.wav");
        JarDataSource jds = new JarDataSource(url);
        jds.connect();
        final Player player = Manager.createPlayer(jds);

        MediaPlayer mp = new MediaPlayer();
        mp.setPlayer(player);
        mp.setPlaybackLoop(true);
        mp.start();
    }
}