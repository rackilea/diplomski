package testas;

import javax.swing.*;

public class Slider {

    static class View {

        public JPanel panel;
        public JSlider slider;
        public JButton button;
        public JTextField tf;

        public View() {
            panel = new JPanel();
            button = new JButton("a");
            slider = new JSlider();
            tf = new JTextField(4);
            panel.add(button);
            panel.add(slider);
            panel.add(tf);
        }


    }

    static class Controller {

        private Object lock;
        private View view;

        public Controller() {
            lock = new Object();
        }

        private synchronized void buttonHandler() {
            new Thread(() -> {
                view.slider.setEnabled(false);
                for(int i=view.slider.getValue()+1;i<=view.slider.getMaximum();i++){
                    synchronized (lock) {
                        view.slider.setValue(i);
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                view.slider.setEnabled(true);
            }).start();
        }

        private synchronized void sliderChangeHandler(int value) {
            new Thread(() -> {
                try {
                    synchronized (lock) {
                        Thread.sleep(1234);//some long calculations
                        view.tf.setText(String.valueOf(value));
                        lock.notify();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }).start();
        }

        public void setView(View v) {

            view = v;
            v.button.addActionListener(l -> buttonHandler());
            v.slider.addChangeListener(l -> {
                JSlider slider = (JSlider) l.getSource();
                if (!slider.getValueIsAdjusting())
                    sliderChangeHandler(slider.getValue());
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controller c = new Controller();
            View v = new View();
            c.setView(v);
            JFrame f = new JFrame();
            f.add(v.panel);
            f.pack();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}