@Override
public IWizardPage getNextPage(final IWizardPage page)
{
  if (!(page instanceof YourFirstPage))  // Next page from first page?
    return super.getNextPage(page);

  // Moving from first to second page, run the progress

  try
   {
     getContainer().run .....
   }
  catch (InvocationTargetException ex)
   {
     // TODO deal with error
   }
  catch (InterruptedException ex)
   {
     // Cancelled
     return null;  // Stay on same page
   }

  return super.getNextPage(page);
}