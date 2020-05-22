dividerContainer = (BasicSplitPaneDivider) splitPane.getComponent(2);
Component leftBtn = dividerContainer.getComponent(0);
Component rightBtn = dividerContainer.getComponent(1);
dividerContainer.setBackground(Color.white);
dividerContainer.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
dividerContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
dividerContainer.add(toolbar);
dividerContainer.setDividerSize(toolbar.getPreferredSize().height);