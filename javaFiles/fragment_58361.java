import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConnectedSlidersExt
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI()
    {
        JSlider s0 = new JSlider(0, 100, 33);
        JSlider s1 = new JSlider(0, 100, 33);
        JSlider s2 = new JSlider(0, 100, 34);

        int expectedSum = 100;
        SliderGroup sliderGroup = new SliderGroup(expectedSum);
        sliderGroup.add(s0);
        sliderGroup.add(s1);
        sliderGroup.add(s2);

        JPanel panel =new JPanel(new GridLayout(0,3));
        panel.add(s0);
        panel.add(createListeningLabel(s0));
        JCheckBox checkBox0 = createCheckBox(s0, sliderGroup);
        panel.add(checkBox0);
        panel.add(s1);
        panel.add(createListeningLabel(s1));
        JCheckBox checkBox1 = createCheckBox(s1, sliderGroup);
        panel.add(checkBox1);
        panel.add(s2);
        panel.add(createListeningLabel(s2));
        JCheckBox checkBox2 = createCheckBox(s2, sliderGroup);
        panel.add(checkBox2);

        keepOneSelected(checkBox0, checkBox1, checkBox2);

        panel.add(createListeningLabel(s0, s1, s2));

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static void keepOneSelected(JCheckBox ...checkBoxes)
    {
        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int numSelected = 0;
                for (JCheckBox checkBox : checkBoxes)
                {
                    if (checkBox.isSelected())
                    {
                        numSelected++;
                    }
                }
                if (numSelected == 1)
                {
                    for (int i = 0; i < checkBoxes.length; i++)
                    {
                        JCheckBox checkBox = checkBoxes[i];
                        if (checkBox.isSelected())
                        {
                            checkBox.setEnabled(false);
                        }
                    }
                }
                else
                {
                    for (int i = 0; i < checkBoxes.length; i++)
                    {
                        JCheckBox checkBox = checkBoxes[i];
                        checkBox.setEnabled(true);
                    }
                }
            }
        };
        for (JCheckBox checkBox : checkBoxes)
        {
            checkBox.addActionListener(actionListener);
        }
    }

    private static JCheckBox createCheckBox(
        JSlider slider, SliderGroup group)
    {
        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(true);
        checkBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (checkBox.isSelected())
                {
                    slider.setEnabled(true);
                    group.addAndAdjust(slider);
                }
                else
                {
                    slider.setEnabled(false);
                    group.removeAndAdjust(slider);
                }
            }
        });

        return checkBox;

    }

    private static JLabel createListeningLabel(final JSlider ... sliders)
    {
        final JLabel label = new JLabel("");
        for (JSlider slider : sliders)
        {
            slider.addChangeListener(new ChangeListener()
            {
                @Override
                public void stateChanged(ChangeEvent e)
                {
                    int sum = 0;
                    for (JSlider slider : sliders)
                    {
                        if (slider.isEnabled())
                        {
                            sum += slider.getValue();
                        }
                    }
                    label.setText("Sum: "+sum);
                }
            });
        }
        return label;
    }

    private static JLabel createListeningLabel(final JSlider slider)
    {
        final JLabel label = new JLabel("");
        slider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                label.setText(String.valueOf(slider.getValue()));
            }
        });
        return label;
    }


}


class SliderGroup
{
    private final int expectedSum;
    private final LinkedList<JSlider> candidates;

    private final ChangeListener changeListener;
    private boolean updating = false;

    SliderGroup(int expectedSum)
    {
        this.expectedSum = expectedSum;
        this.candidates = new LinkedList<JSlider>();

        changeListener = new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                JSlider source = (JSlider)e.getSource();
                update(source);
            }
        };
    }

    private void update(JSlider source)
    {
        if (updating)
        {
            return;
        }
        updating = true;

        for (JSlider slider : candidates)
        {
            slider.setValueIsAdjusting(true);
        }

        if (candidates.size() > 1)
        {
            int delta = computeSum() - expectedSum;
            if (delta > 0)
            {
                distributeRemove(delta, source);
            }
            else
            {
                distributeAdd(delta, source);
            }
        }

        for (JSlider slider : candidates)
        {
            slider.setValueIsAdjusting(false);
        }

        updating = false;
    }


    private void distributeRemove(int delta, JSlider source)
    {
        int counter = 0;
        int remaining = delta;
        while (remaining > 0)
        {
            //System.out.println("remove "+remaining);

            JSlider slider = candidates.removeFirst();
            counter++;

            if (slider == source)
            {
                candidates.addLast(slider);
            }
            else
            {
                if (slider.getValue() > 0)
                {
                    slider.setValue(slider.getValue()-1);
                    remaining--;
                    counter = 0;
                }
                candidates.addLast(slider);
                if (remaining == 0)
                {
                    break;
                }
            }
            if (counter > candidates.size())
            {
                String message =
                    "Can not distribute " + delta + " among " + candidates;
                // System.out.println(message);
                // return;
                throw new IllegalArgumentException(message);
            }
        }
    }

    private void distributeAdd(int delta, JSlider source)
    {
        int counter = 0;
        int remaining = -delta;
        while (remaining > 0)
        {
            //System.out.println("add "+remaining);

            JSlider slider = candidates.removeLast();
            counter++;

            if (slider == source)
            {
                candidates.addFirst(slider);
            }
            else
            {
                if (slider.getValue() < slider.getMaximum())
                {
                    slider.setValue(slider.getValue()+1);
                    remaining--;
                    counter = 0;
                }
                candidates.addFirst(slider);
                if (remaining == 0)
                {
                    break;
                }
            }
            if (counter > candidates.size())
            {
                String message =
                    "Can not distribute " + delta + " among " + candidates;
                // System.out.println(message);
                // return;
                throw new IllegalArgumentException(message);
            }
        }
    }

    private int computeSum()
    {
        int sum = 0;
        for (JSlider slider : candidates)
        {
            sum += slider.getValue();
        }
        return sum;
    }

    void add(JSlider slider)
    {
        candidates.add(slider);
        slider.addChangeListener(changeListener);
    }

    void remove(JSlider slider)
    {
        candidates.remove(slider);
        slider.removeChangeListener(changeListener);
    }

    void addAndAdjust(JSlider slider)
    {
        add(slider);
        if (candidates.size() == 2)
        {
            update(candidates.get(0));
        }
        else
        {
            update(slider);
        }
    }

    void removeAndAdjust(JSlider slider)
    {
        remove(slider);
        update(slider);
        if (candidates.size() == 1)
        {
            JSlider candidate = candidates.get(0);
            int max = candidate.getMaximum();
            candidate.setValue(Math.min(max, expectedSum));
        }
    }


}