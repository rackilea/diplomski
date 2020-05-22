public void choiceOption() throws InvalidInputException {
    char choice = "0";

    while (choice != "q"){
        printMenu();

        System.in.read(choice);
        switch(choice){
        case "1": DisplayNumAlbums();
        case "2": ListAllTitles();
        case "3": DisplayAlbumDetail();
        case "q": System.out.println("Invalid input...");
                  return;
        default: System.out.println("Invalid input...");
                 throw new InvalidInputException();
        }
    }
}