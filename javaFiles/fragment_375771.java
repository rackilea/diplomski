private void addNatureToProject(IProject proj, String natureId, IProgressMonitor monitor) throws CoreException
{
    IProjectDescription description = proj.getDescription();

    String[] prevNatures = description.getNatureIds();

    String[] newNatures = new String[prevNatures.length + 1];

    System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);

    newNatures[prevNatures.length] = natureId;

    description.setNatureIds(newNatures);

    proj.setDescription(description, monitor);
}