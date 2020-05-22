while (total < totalToRead && !stopped) {
    numBytesRead = fis.read(buffer, 0, numBytesToRead);
    if (numBytesRead == -1)
    break;
    total += numBytesRead;
    lineIn.write(buffer, 0, numBytesRead);
}