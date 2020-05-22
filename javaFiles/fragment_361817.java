public static int getCommand(){
    String command = IOTools.readString("Enter Command!");
    if (command.equals("exit")){
        return 1;
    } else if (command.equals("shift")){
        return 0;
    } else {
        return getCommand();
    }
}