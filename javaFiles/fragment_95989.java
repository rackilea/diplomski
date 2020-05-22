while (scanner.hasNext()) {
    contents = scanner.nextLine();

    if ((contents.contains(username)) && (contents.contains(password))) {
        call.fileManager();
        break;
    }

    if ((!contents.contains(username)) && (!contents.contains(password))) {
        JOptionPane.showMessageDialog(null, "Invalid username/password! Check your spelling/capitalization.", "Error!", JOptionPane.ERROR_MESSAGE);
        call.loginFrame();
        break;
    }

 }