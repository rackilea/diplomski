public class CustomHAxis extends HAxis {
/**
 * Default constructor.
 * 
 * @return a new object instance
 */
public static CustomHAxis create() {
    return createObject().cast();
}

/**
 * Constructor with title.
 * 
 * @param title
 *            axis title
 * 
 * @return a new object instance
 */
public static CustomHAxis create(String title) {
    CustomHAxis hAxis = createObject().cast();
    hAxis.setTitle(title);
    return hAxis;
}

protected CustomHAxis() {
}

public final native void setScaleType(String scaleType) /*-{
    this.scaleType = scaleType;
}-*/;
}