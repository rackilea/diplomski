static {
    // choose 1st file's path
    if (CONFIG_FILE_1.exists() && CONFIG_FILE_1.isFile()) {
        loadConfiguration(CONFIG_FILE_1);
    }
    else if (CONFIG_FILE_2.exists() && CONFIG_FILE_2.isFile()) {
         loadConfiguration(CONFIG_FILE_2);
    }
    // choose 2nd file's path
    if (CONFIG_FILE_3.exists() && CONFIG_FILE_3.isFile()) {
         loadConfiguration(CONFIG_FILE_3);
    }
    else if (CONFIG_FILE_4.exists() && CONFIG_FILE_4.isFile()) {
         loadConfiguration(CONFIG_FILE_4);
    }
}