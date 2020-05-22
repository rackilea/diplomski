byteread = is.read(buffer, 0, buffer.length);
    current = byteread;

    do{
        byteread = is.read(buffer, 0, buffer.length - current);
        if (byteread >= 0) current += byteread;
    } while (byteread > -1);