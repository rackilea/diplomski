package com.gmail.bernabe.laurent.jogl.arcball_experiment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class ArcBallExperiment extends JFrame {

    public ArcBallExperiment(){
        setTitle("ArcBall Experimentation");
        setSize(500, 500);
        setLocationRelativeTo(null);

        GLCanvas glCanvas = new GLCanvas();
        TheGLEventListener glEventListener = new TheGLEventListener();
        glCanvas.addGLEventListener(glEventListener);
        add(glCanvas);

        /*
         *  Here I limit the FPS to a quite lower value than default,
         *  thanks to the FPSAnimator class : 180 FPS here.
         *  That way, cube rotation speed will really be constant
         */
        final FPSAnimator animator = new FPSAnimator(glCanvas, 180);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                animator.stop();
                System.exit(0);
            }


        });

        animator.start();
    }

    public static void main(String[] args) {
        new ArcBallExperiment().setVisible(true);
    }

    private static final long serialVersionUID = 1L;

}