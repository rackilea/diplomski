String dataFolder = System.getProperty("user.home") + "/My_Data/Budget_backup";

     File directory = new     File(dataFolder+File.separator+"Budget_app_data_expenses");

    File file = new File(directory+File.separator+ name_of_file);

    Path path = FileSystems.getDefault().getPath(dataFolder, name_of_file );