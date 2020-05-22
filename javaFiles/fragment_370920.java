private StringBuilder text;

    private void updateInput()
    {
        while (Keyboard.next())
        {
            if (Keyboard.getEventKeyState())
            {
                // get key info
                int key = Keyboard.getEventKey();
                char ch = Keyboard.getEventCharacter();
                int ascii = (int) ch;

                // delete case
                if(key == Keyboard.KEY_BACK)
                    text.setLength(Math.max(0, text.length() - 1));

                // append if common char
                if((ascii >= 32 && ascii <= 126) || (ascii >= 128 && ascii <= 255))
                    text.append(ch);
            }
        }
    }