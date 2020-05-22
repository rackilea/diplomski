public boolean isPressed(NativeKeyEvent keyEvent)
{
    val modifiers = keyEvent.getModifiers();
    val isModifierPressed = modifiers == modifier;

    if (!isModifierPressed)
    {
        return false;
    }

    val keyCode = keyEvent.getKeyCode();
    val keyText = NativeKeyEvent.getKeyText(keyCode);
    return keyText.equals(this.keyText);
}