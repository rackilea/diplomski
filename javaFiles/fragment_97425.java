private Component createPanel() {
    JPanel panel = new JPanel();
    panel.setBackground(randomColor());
    panel.setPreferredSize(new Dimension(100,50));
    panel.add(new JLabel("a colored Panel"));
    panel.addMouseListener(new MouseListener() {
        @Override 
        public void mouseClicked(MouseEvent e) {
            int indexPosition  = boxHolder.getComponentZOrder(panel);
            try
            {
                boxHolder.remove(indexPosition);
            }
            catch(Exception ex){}
            try //Will only add here if you have a component in index position 1
            {
                boxHolder.add(createPanel(),indexPosition);
            }
            catch(Exception ex){}
            scrollPaneContainer.revalidate();
        }
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    });
    return panel;
}