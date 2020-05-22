FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
    for(String path : files) {
        System.out.println("path = " + path);
        VirtualFile vf = LocalFileSystem.getInstance().findFileByPath(path);
        fileEditorManager.openFile(vf, true, true);
    }