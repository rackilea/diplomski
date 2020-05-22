if (activityName != null) {
    // create the main activity Java file

    String activityJava = activityName + AdtConstants.DOT_JAVA;

    // Get the path of the package

    IPath path = ((IPackageFragment) firstElement).getPath();
    String pkgpath = path.toString();                               

    String projname = "";

    // Remove the project name from the beginning of the path
    String temp[] = pkgpath.split("/");
    pkgpath = "";
    for (int i = 1; i < temp.length; i++) {
        if (i==1) {
            pkgpath = "/";
            projname = temp[i];
        } else {
            pkgpath = pkgpath + "/" + temp[i];
        }
    }

    // Get the project                
    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projname);  

    IFile file = project.getFile(pkgpath+"/"+activityJava);
    if (!file.exists()) {
        try {
            copyFile("java_file.template", file, java_activity_parameters);
        } catch (CoreException e) {
            AltBridge.log(e, "Couldn't copy the text file", pkgpath);
            e.printStackTrace();
        } catch (IOException e) {
            AltBridge.log(e, "Couldn't copy the text file", pkgpath);
            e.printStackTrace();
        }
    }
}