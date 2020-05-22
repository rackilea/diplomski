boolean continue = true
while (continue) {
    show input dialog and store result in inputString variable
    if (inputString != null) { // user didn't choose to cancel
        try {
            int input = parse inputString as int;
            continue = false; // something valid has been entered, so we stop asking
            do something with the input
        }
        catch (invalid number exception) {
            show error
        }
    }
    else { // user chose to cancel
        continue = false; // stop asking
    }
}