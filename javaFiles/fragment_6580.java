@Override
public boolean canFlipToNextPage()
{
  // Default calls getNextPage() which runs the progress just checking page complete is enough here
  return isPageComplete();
}