$ diff OldSwingPaint.java SwingPaint.java 
38a39,41
>             Graphics2D g2d = (Graphics2D) g;
>             g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
>                 RenderingHints.VALUE_ANTIALIAS_ON);
40c43
<             int d = Math.min(size.width, size.height) - 10;
---
>             int d = 200;