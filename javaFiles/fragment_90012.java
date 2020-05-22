public DragManager(final Canvas canvas)
{
    canvas.addMouseListener(new MouseAdapter() {
        @Override public void mousePressed(MouseEvent e)
        {
            canvas.something();
        }
    });
}