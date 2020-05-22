switch(tabPlacement) {
    case LEFT:
    case RIGHT:
        g.fillRect(x, y + (hSep / 2), w, h - hSep);
    case BOTTOM:
    case TOP:
    default:
        g.fillRect(x + (wSep / 2), y, w - wSep, h);
}