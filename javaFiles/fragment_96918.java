buttonGraphics.setPaint(new GradientPaint(
                        new Point(0, 0), 
                        Color.RED, 
                        new Point(0, getWidth()), 
                        Color.BLUE()));
                buttonGraphics.fillRect(0, 0, getWidth(), getHeight());
                buttonGraphics.dispose()