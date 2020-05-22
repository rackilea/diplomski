AffineTransform originalTransform = g2d.getTransform();
            g2d.transform(tx);

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            ((Graphics2D)g).draw(shape);

            g2d.setTransform(originalTransform);