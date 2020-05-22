void processContainer(IContainer container)
{
   IResource [] members = container.members();

   for (IResource member : members)
    {
      if (member instanceof IContainer) 
       {
         processContainer((IContainer)member);
       }
      else if (member instanceof IFile)
       {
         ... deal with the file
       }
    }
}