package com.ggl.stopwatch.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.ggl.stopwatch.model.StopwatchModel;
import com.ggl.stopwatch.thread.StopwatchThread;

public class StopwatchPanel {

    protected static final Insets entryInsets = new Insets(0, 10, 4, 10);
    protected static final Insets spaceInsets = new Insets(10, 10, 4, 10);

    protected JButton resetButton;
    protected JButton startButton;
    protected JButton splitButton;
    protected JButton stopButton;

    protected JLabel timeDisplayLabel;

    protected JPanel mainPanel;
    protected JPanel buttonPanel;
    protected JPanel startPanel;
    protected JPanel stopPanel;

    protected SplitScrollPane splitScrollPane;

    protected StopwatchModel model;

    protected StopwatchThread thread;

    public StopwatchPanel(StopwatchModel model) {
        this.model = model;
        createPartControl();
    }

    protected void createPartControl() {
        splitScrollPane = new SplitScrollPane(model);

        createStartPanel();
        createStopPanel();
        setButtonSizes(resetButton, startButton, splitButton, stopButton);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JPanel displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 6));

        timeDisplayLabel = new JLabel(model.formatTime(0L, 0L, true));
        timeDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = timeDisplayLabel.getFont();
        Font labelFont = font.deriveFont(60.0F);
        timeDisplayLabel.setFont(labelFont);
        timeDisplayLabel.setForeground(Color.BLUE);
        displayPanel.add(timeDisplayLabel);

        addComponent(mainPanel, displayPanel, 0, gridy++, 1, 1, spaceInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        buttonPanel = new JPanel();
        buttonPanel.add(startPanel);
        addComponent(mainPanel, buttonPanel, 0, gridy++, 1, 1, spaceInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        addComponent(mainPanel, splitScrollPane.getSplitScrollPane(), 0, gridy++, 1, 1, spaceInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
    }

    protected void createStartPanel() {
        startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                model.resetTimes();
                timeDisplayLabel.setText(model.formatTime(0L, 0L, true));
                splitScrollPane.clearPanel();
                mainPanel.repaint();
            }
        });

        startPanel.add(resetButton);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                model.setStartTime();
                thread = new StopwatchThread(StopwatchPanel.this);
                thread.start();
                displayStopPanel();
            }
        });

        startPanel.add(startButton);
    }

    protected void createStopPanel() {
        stopPanel = new JPanel();
        stopPanel.setLayout(new FlowLayout());

        splitButton = new JButton("Split");
        splitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                model.setSplitTime();
                splitScrollPane.addSplit(model.getStartTime(), 
                        model.getPenultimateSplitTime(), 
                        model.getLastSplitTime());
                splitScrollPane.setMaximum();
                splitScrollPane.repaint();
            }
        });

        stopPanel.add(splitButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                model.setEndTime();
                thread.setRunning(false);
                if (model.isSplitTime()) {
                    splitScrollPane.addSplit(model.getStartTime(), 
                            model.getPenultimateSplitTime(), 
                            model.getLastSplitTime());
                    splitScrollPane.setMaximum();
                    splitScrollPane.repaint();
                }
                displayStartPanel();
            }
        });

        stopPanel.add(stopButton);
    }

    protected void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, 
            Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    protected void displayStopPanel() {
        buttonPanel.remove(startPanel);
        buttonPanel.add(stopPanel);
        buttonPanel.repaint();
    }

    protected void displayStartPanel() {
        buttonPanel.remove(stopPanel);
        buttonPanel.add(startPanel);
        buttonPanel.repaint();
    }

    protected void setButtonSizes(JButton ... buttons) {
        Dimension preferredSize = new Dimension();
        for (JButton button : buttons) {
            Dimension d = button.getPreferredSize();
            preferredSize = setLarger(preferredSize, d);
        }
        for (JButton button : buttons) {
            button.setPreferredSize(preferredSize);
        }
    }

    protected Dimension setLarger(Dimension a, Dimension b) {
        Dimension d = new Dimension();
        d.height = Math.max(a.height, b.height);
        d.width = Math.max(a.width, b.width);
        return d;
    }

    public void setTimeDisplayLabel() {
        this.timeDisplayLabel.setText(model.formatTime(model.getStartTime(), 
                System.currentTimeMillis(), true));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}