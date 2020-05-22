@Override
public boolean performFinish()
{
  if (!super.performFinish())
    return false;

  IProject newProject = getNewProject();

  IFolder newFolder = newProject.getFolder(new Path("relative path for folder"));

  newFolder.create(false, true, progress monitor);

  return true;
}