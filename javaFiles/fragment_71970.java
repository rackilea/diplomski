@Override
public void mouseEntered(MouseEvent e) {
    int modifiersEx = e.getModifiersEx();
    int onmask = MouseEvent.SHIFT_DOWN_MASK;
    if ((modifiersEx & onmask) == onmask) {
        // Shift key is down
    }
}