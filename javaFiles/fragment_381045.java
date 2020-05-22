bool blankLineRead = false;
while ((line = reader.readLine()) != null) {
    //Inside the cicle line is surely not null
    if (line.trim().lenght() <= 0)
        blankLineRead = true;
    else
        if (blankLineRead) {
            log.debug("Terminating on first blank line");// terminate on first blank line
            break;
        }
}