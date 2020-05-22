if (b == splitFileSize) {
        output.close();
        i++;
        numberOfPieces--;
        output = new BufferedOutputStream(new FileOutputStream(fn + i));
        b=0;
    }