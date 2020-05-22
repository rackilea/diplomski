String home = System.getProperty("user.home");

File data_directory = new File(home, ".my_app_data");
data_directory.mkdir();

File log_file = new File(data_directory, "jamie.txt");
try {
    log_file.createNewFile();
} catch (IOException e) {
    // handle error
}