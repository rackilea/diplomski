public class Circle {
    public int X, Y, radius;
    public Color color;
    public boolean toFill;

    public Circle(int x, int y, int radius, Color color, boolean fill) {
        X = x;
        Y = y;
        this.radius = radius;
        this.color = color;
        toFill = fill;
    }

    public void render(Graphics g) {
        g.setColor(color);
        final int r2 = 2*radius;
        if(toFill) {
            g.fillOval(X, Y, r2, r2);           
        }
        else {
            for(int i=-5; i<5; i++) {
                g.drawOval(X+i, Y+i, r2-i, r2-i);
            }
        }
    }

    public boolean contains(Circle pBound) {
        int pBoundCenterX = pBound.X+pBound.radius;
        int cirCenterX = X+radius;

        int diffBetweenCentersX = Math.abs(pBoundCenterX-cirCenterX);

        int pBoundCenterY = pBound.Y+pBound.radius;
        int cirCenterY = Y+radius;

        int diffBetweenCentersY = Math.abs(pBoundCenterY-cirCenterY);
        if(diffBetweenCentersX<= (pBound.radius+radius) && diffBetweenCentersX>=Math.abs(pBound.radius-radius)) { // X
            if(diffBetweenCentersY>=Math.abs(pBound.radius-radius)) { // Y
                return true;
            }
        }

        return false;
    }

    public int getX() {
        return X;
    }

    public int getRadius() {
        return radius;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}