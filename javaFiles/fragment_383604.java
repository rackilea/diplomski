g.drawString("Resume", 200, 156);
resumeRect= g.getFontMetrics().getStringBounds("Resume", g);

// Add this:
resumeRect.setRect(200,
                   156 - g.getFontMetrics().getAscent(),
                   resumeRect.getWidth(),
                   resumeRect.getHeight());