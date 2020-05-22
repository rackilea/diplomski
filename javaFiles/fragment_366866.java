public void split(String filePath, long splitLen, String name) {
    File fileSource = new File(filePath);
    int count = 0;
    boolean endOfFile = false;
    String lineSeparator = System.getProperty("line.separator");
    int hour = 0; // an accumulator for hours
    int min = 0; // an accumulator for minutes
    int sec = (int) splitLen; // an accumulator for seconds
    int _hour = 0; // hours from the file
    int _min = 0; // minutes from the file
    int _sec = 0; // seconds from the file
    try (   // try with resources to close files automatically
            FileReader frSource = new FileReader(fileSource);
            BufferedReader buffSource = new BufferedReader(frSource);
            ) {
        String strIn = null;
        while(!endOfFile) {
            File fileOut = new File("f:\\test\\mysrt\\" + count + ".srt");
            try (   // try with resources to close files automatically
                    FileWriter fwOut = new FileWriter(fileOut);
                    ) {
                if (strIn != null) {
                    // write out the last line read to the new file
                    fwOut.write(strIn + lineSeparator);
                }
                for (int i = 0; i < splitLen; i++) {
                    strIn = buffSource.readLine();
                    if (strIn == null) {
                        endOfFile = true; // stop the while loop
                        break; // exit the for loop
                    }
                    if (strIn.indexOf("-->") > 0) {
                        String endTime = strIn.split("-->")[1];
                        _hour = extractHours(endTime); // get the hours from the file
                        _min = extractMinutes(endTime); // get the minutes from the file
                        _sec = extractSeconds(endTime); // get the seconds from the file
                        if (_hour >= hour && _min >= min && _sec >= sec) { // if the file time is greater than our accumulators
                            sec += splitLen; // increment our accumulator seconds
                            if (sec >= 60) { // if accumulator seconds is greater than 59, we need to convert it to minutes and seconds
                                min += sec / 60;
                                sec = sec % 60;
                            }
                            if (min >= 60) { if accumulator minutes is greater than 59, we need to convert it to hours and minutes
                                hour += min / 60;
                                min = min % 60;
                            }
                            break; // break out of the for loop, which cause the file to be completed and a new file started.
                        }
                    }
                    fwOut.write(strIn + lineSeparator); // write out to the new file
                }
                fwOut.flush();
            }
            count++;
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private int extractMinutes(String time) {
    // You need to implement this, I don't know the format of your time
    return 0;
}

private int extractSeconds(String time) {
    // You need to implement this, I don't know the format of your time
    return 0;
}