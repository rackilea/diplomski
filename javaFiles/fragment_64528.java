import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.media.*;
import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;


    public class mediaPlayer extends JFrame
    {
        public mediaPlayer()
        {   
        JFrame f = new JFrame("Video Demo");
            f.setLayout(new BorderLayout());
            f.setSize(500,300);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //file you want to play
            try{
                String name = "file:///"+new File("output.mp4").getAbsolutePath();
                URL mediaURL = new URL(name);
                Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
            //get components for video and playback controls
            Component video = mediaPlayer.getVisualComponent();
            Component controls = mediaPlayer.getControlPanelComponent();
            f.add(video,BorderLayout.CENTER);
            f.add(controls,BorderLayout.SOUTH);
            } catch (Exception e) { e.printStackTrace(); }
            f.setVisible(true);

        }
        public static void main(String[] args){
            new mediaPlayer();
        }
    }