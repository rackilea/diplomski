package com.pl.button;

import net.rim.device.api.ui.*;
import net.rim.device.api.system.*;

public class imagefield extends Field {

private String _label;
private int _labelHeight;
private int _labelWidth;
private Font _font;

private Bitmap _currentPicture;
private Bitmap _onPicture; 
private Bitmap _offPicture; 
int color;

public imagefield (String text, long style ,String img, String img_hvr, int color){
    super(style);


    _offPicture = Bitmap.getBitmapResource(img);
    _onPicture = Bitmap.getBitmapResource(img_hvr);

    _font = getFont();
    _label = text;
    _labelHeight = _onPicture.getHeight();  
    _labelWidth = _onPicture.getWidth();

    this.color = color;

    _currentPicture = _offPicture;
}

/**
 * @return The text on the button
 */
String getText(){
    return _label;
}

/**
 * Field implementation.
 * @see net.rim.device.api.ui.Field#getPreferredHeight()
 */
public int getPreferredHeight(){
    return _labelHeight;
}

/**
 * Field implementation.
 * @see net.rim.device.api.ui.Field#getPreferredWidth()
 */
public int getPreferredWidth(){
    return _labelWidth;
}

/**
 * Field implementation.  Changes the picture when focus is gained.
 * @see net.rim.device.api.ui.Field#onFocus(int)
 */
protected void onFocus(int direction) {
    _currentPicture = _onPicture;
    invalidate();
}

/**
 * Field implementation.  Changes picture back when focus is lost.
 * @see net.rim.device.api.ui.Field#onUnfocus()
 */
protected void onUnfocus() {
    _currentPicture = _offPicture;
    invalidate();
}

/**
 * Field implementation.  
 * @see net.rim.device.api.ui.Field#drawFocus(Graphics, boolean)
 */
protected void drawFocus(Graphics graphics, boolean on) {
    // Do nothing
}

/**
 * Field implementation.
 * @see net.rim.device.api.ui.Field#layout(int, int)
 */
protected void layout(int width, int height) {
    setExtent(Math.min( width, getPreferredWidth()), 
    Math.min( height, getPreferredHeight()));
}

/**
 * Field implementation.
 * @see net.rim.device.api.ui.Field#paint(Graphics)
 */
protected void paint(Graphics graphics){       
    // First draw the background colour and picture
    graphics.setColor(this.color);
    graphics.fillRect(0, 0, getWidth(), getHeight());
    graphics.drawBitmap(0, 0, getWidth(), getHeight(), _currentPicture, 0, 0);

    // Then draw the text
    graphics.setColor(Color.BLACK);
    graphics.setFont(_font);
    graphics.drawText(_label, 4, 2, 
        (int)( getStyle() & DrawStyle.ELLIPSIS | DrawStyle.HALIGN_MASK ),
        getWidth() - 6 );
}

/**
 * Overridden so that the Event Dispatch thread can catch this event
 * instead of having it be caught here..
 * @see net.rim.device.api.ui.Field#navigationClick(int, int)
 */
protected boolean navigationClick(int status, int time){
    fieldChangeNotify(1);
    return true;
}