String choice;
do {
    choice = scanner.nextLine();
    switch (choice) {
        case "1":
            encrypt();
            break;
        case "2":
            decrypt();
            break;
        case "3":
            makeKey();
            break;
    } 
} while (!choice.equals("4"));