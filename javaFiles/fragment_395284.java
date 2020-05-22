// If the file existed and now doesn't
if (this.exists && !this.file.exists())
{
  this.exists = this.file.exists();
  this.timestamp = -1;

  // Fire delete event

  ((AbstractFileSystem)
     this.file.getFileSystem()).fireFileDeleted(this.file);

  // Remove listener in case file is re-created. Don't want to fire twice.
  if (this.fm.getFileListener() != null)
  {
     this.file.getFileSystem().removeListener(this.file,
        this.fm.getFileListener());
  }

  // Remove from map
  this.fm.queueRemoveFile(this.file);
}