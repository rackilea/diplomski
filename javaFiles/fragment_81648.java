String userInput = scanner.nextLine();

while(!userInput.trim().equals("q")) { 
    if (!Folder.folderExists(userInput, folders)){ //checks if a folder with the same name exists
        folders.add(new Folder(userInput, Folder.getNextFolderID(folders)));
        System.out.println("Add new folder or press q to cancel: ");
    }
    else{
        System.out.println("A folder with the same name already exists. Choose a new folder name or press q to cancel: ");
    }
    userInput = scanner.nextLine();
}