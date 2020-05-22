package deck.displayer;

import java.awt.Component;
import java.awt.Font;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Javier A. Ortiz <javier.ortiz.78@gmail.com>
 */
public class CardCellRenderer extends JLabel implements ListCellRenderer {

    private Font uhOhFont;

    @Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    if (isSelected) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
    } else {
        setBackground(list.getBackground());
        setForeground(list.getForeground());
    }
    Card card = (Card) value;
    setIcon(card.getIcon());
    if (getIcon() != null) {
        if (index != list.getModel().getSize() - 1) {
            setIcon(new ImageIcon(createImage(new FilteredImageSource(((ImageIcon) getIcon()).getImage().getSource(),
                    new CropImageFilter(0, 0, getIcon().getIconWidth(), 20)))));
        }
        setFont(list.getFont());
    } else {
        setUhOhText(card.getText() + " (no image available)",
                list.getFont());
    }
    return this;
}
//Set the font and text when no image was found.

protected void setUhOhText(String uhOhText, Font normalFont) {
    if (uhOhFont == null) { //lazily create this font
        uhOhFont = normalFont.deriveFont(Font.ITALIC);
    }
    setFont(uhOhFont);
    setText(uhOhText);
}
}