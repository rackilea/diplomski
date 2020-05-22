package deck.displayer;

import javax.swing.ImageIcon;

/**
*
* @author Javier A. Ortiz <javier.ortiz.78@gmail.com>
*/
public class Card {

private String text;
private ImageIcon icon;

public Card(String text, ImageIcon icon) {
    this.text = text;
    this.icon = icon;
}

/**
 * @return the text
 */
public String getText() {
    return text;
}

/**
 * @return the icon
 */
public ImageIcon getIcon() {
    return icon;
}
}