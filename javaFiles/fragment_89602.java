public void draw(UserInterface ui) {
    if (isFilled) {
        ui.fillColor(color);
    } else {
        ui.lineColor(color);
    }
    ui.drawPolygon(xPoints, yPoints, isFilled);
}