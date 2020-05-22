Composite body = (Composite)getControl();

findText(body);

...

private void findText(Composite composite)
{
  Control [] children = composite.getChildren();
  if (children == null || children.length == 0)
    return;

  for (Control child : children)
   {
     if (child == null || child.isDisposed())
       continue;

     if (child instanceof Composite)
       findText((Composite)child);

     if (child instanceof Text)
      {
        ... handle Text control
      }  
   } 
}