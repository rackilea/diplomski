String homeDir = System.getProperty("user.home");

File desktop = new File(homeDir, "Desktop");

File[] fileList = desktop.listFiles();

for (File file : fileList) {
    System.out.println(file.getName());
}