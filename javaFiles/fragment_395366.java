while (true) {
    try {
        input = keyboard.nextLine();
        writer.write(input);
        System.out.println("IN: "+input);
        writer.newLine();
        writer.flush();
    } catch (IOException ex) {
        Logger.getLogger(CmdLineTest.class.getName()).log(Level.SEVERE, null, ex);
    }

}