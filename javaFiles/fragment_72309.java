/**
 * This method scrolls based upon the passed parameters
 * @author Bill Hileman
 * @param int startx - the starting x position
 * @param int starty - the starting y position
 * @param int endx - the ending x position
 * @param int endy - the ending y position
 */
@SuppressWarnings("rawtypes")
public void scroll(int startx, int starty, int endx, int endy) {

    TouchAction touchAction = new TouchAction(driver);

    touchAction.longPress(PointOption.point(startx, starty))
               .moveTo(PointOption.point(endx, endy))
               .release()
               .perform();

}