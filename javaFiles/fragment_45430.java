public void actionPerformed(AnActionEvent e) {

    // Create/Modify files

    // Get the project from the ActionEvent
    Project project = e.getData(PlatformDataKeys.PROJECT);

    // Get the Base Dir and refresh with the following parameters
    // 'asynchronous' set to false and 'recursive' set to true
    project.getBaseDir().refresh(false,true);

}