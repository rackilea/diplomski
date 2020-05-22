public Control getControl(Composite composite, int x, int y)
{
  Control control = null;
  Control[] children = composite.getChildren()
  if (children.length == 0)
     control = composite;
  else
    for (Control tmp : children) {
       // The check below will not work because x, y and the control's bounds could be
       // relative to different parents... Better to convert all coordinates to display
       // by using Control.toDisplay() and then compare below
       if (tmp.getBounds().contains(x, y)) 
       {
         if (control instanceof Composite)
             control = getControl(tmp, x, y);
         else
             control =  tmp;
         break;
       }

    }

  return control;
}