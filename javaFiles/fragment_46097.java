do
    {
        data = in.read();
        if ( (char) data == '>') {
            break;
        }
        buffer[len++] = (byte) data;
    } 
    while(data != -1);