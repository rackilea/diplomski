for (File file : files) {
    XMLMessage message = new XMLMessage();
    xmlMessageList.add(message);
    if (file.isDirectory()) {
        String fileName = file.getName();
        System.out.print(fileName);
        message.setFileName(fileName);

        //folderFile.setFileName(fileName);
        showFiles(file.listFiles()); // Calls same method again.
    } else {
        ... etc, using message instead of xmlMessageList.get(i)
    }
}