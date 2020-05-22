package com.barbarysoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class ImageLoadingDemo {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(600, 400));
        frame.getContentPane().add(new JLabel("I'm the main app frame", JLabel.CENTER));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        final JDialog pleaseWaitDialog = new JDialog(frame, "Loading images", true);

        final int imageCount = 50;
        final JProgressBar progressBar = new JProgressBar(0, imageCount);

        final BufferedImage[] images = loadImages(frame, pleaseWaitDialog, imageCount, progressBar);
        System.out.println("images = " + images);
    }

    private static BufferedImage[] loadImages(JFrame frame, final JDialog pleaseWaitDialog, final int imageCount, final JProgressBar progressBar) {
        final BufferedImage[] images = new BufferedImage[imageCount];
        SwingWorker<Void, Integer> swingWorker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < imageCount; i++) {
                    System.out.println("i = " + i);
                    publish(i);
                    Thread.sleep(1000); // to simulate the time needed to load an image
//                    images[i] = ImageIO.read(new File("... path to an image file ..."));
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                final Integer integer = chunks.get(chunks.size() - 1);
                progressBar.setValue(integer);
            }

            @Override
            protected void done() {
                pleaseWaitDialog.setVisible(false);
            }
        };
        JPanel panel = new JPanel();
        panel.add(progressBar);
        panel.add(new JButton(new AbstractAction("Cancel") {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));
        pleaseWaitDialog.getContentPane().add(panel);
        pleaseWaitDialog.pack();
        pleaseWaitDialog.setLocationRelativeTo(frame);
        swingWorker.execute();
        pleaseWaitDialog.setVisible(true);
        return images;
    }
}