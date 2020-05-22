package com.ziesemer.test;

import java.net.URL;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;

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

        player.addControllerListener(new ControllerListener(){
            @Override
            public void controllerUpdate(ControllerEvent ce){
                if(ce instanceof EndOfMediaEvent){
                    player.setMediaTime(new Time(0));
                    player.start();
                }
            }
        });
        player.start();
    }
}