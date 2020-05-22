public void init(IEditorSite site, IEditorInput input)
 throws PartInitException
{
  ... other code

  ImageDescriptor desc = input.getImageDescriptor();

  Image image = desc.createImage();

  setTitleImage(image);

  ... other code
}