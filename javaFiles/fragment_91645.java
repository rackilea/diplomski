RandomAccessFile f = new RandomAccessFile("input.txt","r"); // r=read-only
    int ch;
    while ((ch = f.read()) != -1) {
        // read once
    }

    f.seek(0); // seek to beginning

    while ((ch = f.read()) != -1) {
        // read again
    }