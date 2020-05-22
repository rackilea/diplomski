boolean enterOnce = false;

while(scanner.hasNextLine()) {
    String line = scanner.nextLine();

    if(line.isEmpty())
        if(enterOnce)
            break;
        else
            enterOnce = true;
}