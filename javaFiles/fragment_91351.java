JLabel[] item = new JLabel[items.length];

for (i = 0; i < items.length; i++) {


    item[i] = new JLabel(items[i]);
    // ...
    add(item[i]);
    item[i].addMouseListener(new YourMouseListener(item[i], items[i]));
    repaint();
}