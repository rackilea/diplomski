if (osName.equals("Windows 95") || osName.equals("Windows 98") || osName.equalsIgnoreCase("Windows ME")) {
    cmd = new String[3];
    cmd[0] = WINDOWS_9X_ME_COMMAND_1;
    cmd[1] = WINDOWS_9X_ME_COMMAND_2;
    cmd[2] = command;
}
else {
    cmd = new String[3];
    cmd[0] = WINDOWS_NT_2000_COMMAND_1;
    cmd[1] = WINDOWS_NT_2000_COMMAND_2;
    cmd[2] = command;
}