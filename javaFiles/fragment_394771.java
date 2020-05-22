public static char getCharacter(int vkCode, boolean shiftKeyPressed)
{

    byte[] keyStates = new byte[256]; //Create a keyboard map of 256 keys

    if (shiftKeyPressed)
    {
        keyStates[16]=-127; //Emulate the shift key being held down
        keyStates[160]=-128; //This needs to be set as well
    }

    IntByReference keyblayoutID = User32.INSTANCE.GetKeyboardLayout(0); //Load local keyboard layout

    int ScanCode  = User32.INSTANCE.MapVirtualKeyExW(vkCode, MAPVK_VK_TO_VSC, keyblayoutID); //Get the scancode

    char[] buff = new char[1];

    int ret = User32.INSTANCE.ToUnicodeEx(vkCode, ScanCode, keyStates, buff, 1, 0, _currentInputLocaleIdentifier);

    switch (ret)
    {
    case -1: //Error
        return (char) -1;

    case 0:  //No Translation
        return (char) 0;

    default: //Returning key...
        return buff[0];
    }
}