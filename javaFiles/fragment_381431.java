public class digit extends Pane {

    double startX, startY, digitWidth, digitHeight, lineWidth;

    Polygon top ;
    Polygon middle ;
    Polygon bottom ;
    Polygon upperLeft ;
    Polygon upperRight ;
    Polygon upperLeft ;
    Polygon lowerLeft ;

    public digit(double startX, double startY, double digitWidth, double digitHeight)
    {
        this.startX = startX;
        this.startY = startY;
        this.digitWidth = digitWidth;
        this.digitHeight = digitHeight;
        lineWidth = digitHeight / 20;
        getChildren().addAll(top,middle,bottom,upperLeft,upperRight,lowerLeft,lowerRight, c);
        this.top = new Polygon(startX, startY, startX + digitWidth, startY, startX + digitWidth - lineWidth, startY + lineWidth * .95, startX + lineWidth, startY + lineWidth * .95);

        // etc...
    }

}