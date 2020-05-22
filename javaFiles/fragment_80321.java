wwd.getInputHandler().addMouseListener(new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent event)
        {
            // right-click context-menu
            if(event.getButton() == MouseEvent.BUTTON3)
            {
                Position p = wwd.getCurrentPosition();
                // abort if not on-map
                if(p == null) return;

                // need later to know what was right-clicked on
                mPositionAtRightClickMoment = wwd.getCurrentPosition();

                rclickMenu.show(component, event.getX(), event.getY());
            }
        }
    });