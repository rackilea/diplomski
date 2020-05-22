package uk.ac.cam.cdi.web;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @version 1.13 2007-06-12
 * @author Cay Horstmann
 */
public class SliderTest
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
                             {
      public void run()
      {
        SliderTestFrame frame = new SliderTestFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}

/**
 * A frame with many sliders and a text field to show slider values.
 */
class SliderTestFrame extends JFrame
{
  private JSlider slider1 = new JSlider();
  private JSlider slider2 = new JSlider();

  public SliderTestFrame()
  {
    setTitle("SliderTest");
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    sliderPanel = new JPanel();
    sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    // common listener for all sliders
    listener = new ChangeListener()
    {
      public void stateChanged(ChangeEvent event)
      {
        // update text field when the slider value changes
        textField.setText("" + (slider1.getValue() + slider2.getValue()));
      }
    };


      // add a slider with alphabetic labels

    slider1 = new JSlider();
    slider1.setInverted(true);
    slider1.setPaintLabels(true);
    slider1.setSnapToTicks(true);
    slider1.setMajorTickSpacing(20);
    slider1.setMinorTickSpacing(20);

    Dictionary<Integer, Component> labelTable1 = new Hashtable<Integer, Component>();
    labelTable1.put(0, new JLabel("F")); //This should have a value of 0
    labelTable1.put(20, new JLabel("E")); //This should have a value of 1000
    labelTable1.put(40, new JLabel("D")); //This should have a value of 1250
    labelTable1.put(60, new JLabel("C")); //This should have a value of 1500
    labelTable1.put(80, new JLabel("B")); //This should have a value of 1750
    labelTable1.put(100, new JLabel("A")); //This should have a value of 2000

    slider1.setLabelTable(labelTable1);
    addSlider(slider1, "Swedish");

      // add a slider with alphabetic labels

    slider2 = new JSlider();
    slider2.setInverted(true);
    slider2.setPaintLabels(true);
    slider2.setSnapToTicks(true);
    slider2.setMajorTickSpacing(20);
    slider2.setMinorTickSpacing(20);

    Dictionary<Integer, Component> labelTable2 = new Hashtable<Integer, Component>();
    labelTable2.put(0, new JLabel("F")); //This should have a value of 0
    labelTable2.put(20, new JLabel("E")); //This should have a value of 1000
    labelTable2.put(40, new JLabel("D")); //This should have a value of 1250
    labelTable2.put(60, new JLabel("C")); //This should have a value of 1500
    labelTable2.put(80, new JLabel("B")); //This should have a value of 1750
    labelTable2.put(100, new JLabel("A")); //This should have a value of 2000

    slider2.setLabelTable(labelTable2);
    addSlider(slider2, "PE");

    /* ...And about 20 other slides more with the same structure */


    textField = new JTextField();
    add(sliderPanel, BorderLayout.CENTER); // add the text field that displays the slider value
    add(textField, BorderLayout.SOUTH);
  }

  /*
   * Adds a slider to the slider panel and hooks up the listener
   * @param s the slider
   * @param description the slider description
   */
  public void addSlider(JSlider s, String description)
  {
    s.addChangeListener(listener);
    JPanel panel = new JPanel();
    panel.add(s);
    panel.add(new JLabel(description));
    sliderPanel.add(panel);
  }

  public static final int DEFAULT_WIDTH = 350;
  public static final int DEFAULT_HEIGHT = 450;

  private JPanel sliderPanel;
  private JTextField textField;
  private ChangeListener listener;
}