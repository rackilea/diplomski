//in Launcher

EnumSet<DownloadFileS> filesToUpdate = checkForUpdates(DownloadFiles.values());

listFilesToUpdate(filesToUpdate);

downloadFiles(filesToUpdate);