wwd.getInputHandler().addMouseListener(new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent event)
        {
            // right-click context-menu
            if(event.getButton() == MouseEvent.BUTTON3)
            {
                // component is my JPanel which contains the WorldWindow
                rclickMenu.show(component, event.getX(), event.getY());
            }
        }
    });