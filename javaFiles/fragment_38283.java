private void input_showerMouseReleased(java.awt.event.MouseEvent evt) {                                           
    end_x = evt.getX();
    end_y = evt.getY();
    paint(input_shower.getGraphics());
    input_shower.revalidate();
}