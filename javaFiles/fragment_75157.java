FileFilter filters = new FailFastFileFilter(
    new ExcludeDirFileFilter("Sub3"), // always exclude Sub3
    (!Settings.getSiemensOptionAWL() ? new ExcludeExtensionInDirFileFilter("Sub1",".awl"), null), // Exclude Sub1/*.awl if desired
    (!Settings.getSiemensOptionSCL() ? new ExcludeExtensionInDirFileFilter("Sub1",".scl"), null) // Exclude Sub1/*.scl if desired
);

FileUtils.copyDirectory(srcDir, dstDir, filters);