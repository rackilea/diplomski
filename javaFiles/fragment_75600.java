/** Handle ItemEvents. */
@Override
public void itemStateChanged(ItemEvent e) {
    GameButton gb = (GameButton) e.getItem();
    gb.setState();
}

/** Remove a and b from play. */
private void retirePair(GameButton a, GameButton b) {
    a.setSelected(true);
    a.setEnabled(false);
    b.setSelected(true);
    b.setEnabled(false);
}

class GameButton extends JToggleButton {
    ...
    public void setState() {
        if (this.isSelected() || !this.isEnabled()) {
            this.setIcon(icon);
        } else {
            this.setIcon(hidden);
        }
    }
}