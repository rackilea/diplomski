public void setDirection(int value) {
            if ((value & (NORTH | SOUTH)) != 0)
                    orientation = VERTICAL;
            else
                    orientation = HORIZONTAL;
            direction = value;
            revalidate();
            repaint();
    }